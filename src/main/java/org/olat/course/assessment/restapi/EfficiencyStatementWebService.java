/**
 * <a href="http://www.openolat.org">
 * OpenOLAT - Online Learning and Training</a><br>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); <br>
 * you may not use this file except in compliance with the License.<br>
 * You may obtain a copy of the License at the
 * <a href="http://www.apache.org/licenses/LICENSE-2.0">Apache homepage</a>
 * <p>
 * Unless required by applicable law or agreed to in writing,<br>
 * software distributed under the License is distributed on an "AS IS" BASIS, <br>
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. <br>
 * See the License for the specific language governing permissions and <br>
 * limitations under the License.
 * <p>
 * Initial code contributed and copyrighted by<br>
 * frentix GmbH, http://www.frentix.com
 * <p>
 */
package org.olat.course.assessment.restapi;

import static org.olat.restapi.security.RestSecurityHelper.isAdmin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.olat.basesecurity.BaseSecurity;
import org.olat.core.CoreSpringFactory;
import org.olat.core.id.Identity;
import org.olat.course.assessment.EfficiencyStatement;
import org.olat.course.assessment.UserEfficiencyStatement;
import org.olat.course.assessment.manager.EfficiencyStatementManager;
import org.olat.course.assessment.model.EfficiencyStatementVO;
import org.olat.resource.OLATResource;
import org.olat.resource.OLATResourceManager;
import org.springframework.stereotype.Component;

/**
 * 
 * Initial date: 17.11.2014<br>
 * @author srosse, stephane.rosse@frentix.com, http://www.frentix.com
 *
 */
@Component
@Path("repo/courses/{resourceKey}/statements")
public class EfficiencyStatementWebService {
	
	@GET
	@Path("{identityKey}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getEfficiencyStatement(@PathParam("identityKey") Long identityKey, @PathParam("resourceKey") Long resourceKey,
			@Context HttpServletRequest request) {
		
		if(!isAdmin(request)) {
			return Response.serverError().status(Status.UNAUTHORIZED).build();
		}
		
		BaseSecurity baseSecurity = CoreSpringFactory.getImpl(BaseSecurity.class);
		Identity assessedIdentity = baseSecurity.loadIdentityByKey(identityKey);
		if(assessedIdentity == null) {
			return Response.serverError().status(Response.Status.NOT_FOUND).build();
		}

		UserEfficiencyStatement efficiencyStatement = CoreSpringFactory
				.getImpl(EfficiencyStatementManager.class)
				.getUserEfficiencyStatementLightByResource(resourceKey, assessedIdentity);
		if(efficiencyStatement == null) {
			return Response.serverError().status(Response.Status.NOT_FOUND).build();
		}
		
		EfficiencyStatementVO statementVO = new EfficiencyStatementVO(efficiencyStatement);
		return Response.ok(statementVO).build();
	}
	
	/**
	 * Create a new efficiency statement.
	 * 
	 * @response.representation.200.doc If the statement was persisted 
	 * @response.representation.401.doc The roles of the authenticated user are not sufficient
	 * @response.representation.404.doc The identity or the resource cannot be found
	 * @param identityKey The owner of the certificate
	 * @param resourceKey The primary key of the resource of the repository entry of the course.
	 * @return Nothing special
	 */
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response putEfficiencyStatement(@PathParam("resourceKey") Long resourceKey,
						EfficiencyStatementVO efficiencyStatementVO, @Context HttpServletRequest request) {
		return putEfficiencyStatement(efficiencyStatementVO.getIdentityKey(), resourceKey, efficiencyStatementVO, request);
	}

	/**
	 * Create a new efficiency statement.
	 * 
	 * @response.representation.200.doc If the statement was persisted 
	 * @response.representation.401.doc The roles of the authenticated user are not sufficient
	 * @response.representation.404.doc The identity or the resource cannot be found
	 * @param identityKey The owner of the certificate
	 * @param resourceKey The primary key of the resource of the repository entry of the course.
	 * @return Nothing special
	 */
	@PUT
	@Path("{identityKey}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response putEfficiencyStatement(@PathParam("identityKey") Long identityKey, @PathParam("resourceKey") Long resourceKey,
						EfficiencyStatementVO efficiencyStatementVO, @Context HttpServletRequest request) {
		
		if(!isAdmin(request)) {
			return Response.serverError().status(Status.UNAUTHORIZED).build();
		}
		
		BaseSecurity baseSecurity = CoreSpringFactory.getImpl(BaseSecurity.class);
		Identity assessedIdentity = baseSecurity.loadIdentityByKey(identityKey);
		if(assessedIdentity == null) {
			return Response.serverError().status(Response.Status.NOT_FOUND).build();
		}

		EfficiencyStatementManager efficiencyStatementManager = CoreSpringFactory.getImpl(EfficiencyStatementManager.class);

		EfficiencyStatement efficiencyStatement = efficiencyStatementManager.getUserEfficiencyStatementByResourceKey(resourceKey, assessedIdentity);
		if(efficiencyStatement != null) {
			return Response.serverError().status(Response.Status.CONFLICT).build();
		}
		
		Date creationDate = efficiencyStatementVO.getCreationDate();
		Float score = efficiencyStatementVO.getScore();
		Boolean passed = efficiencyStatementVO.getPassed();

		OLATResourceManager resourceManager = CoreSpringFactory.getImpl(OLATResourceManager.class);
		OLATResource resource = resourceManager.findResourceById(resourceKey);
		if(resource == null) {
			String courseTitle = efficiencyStatementVO.getCourseTitle();
			efficiencyStatementManager.createStandAloneUserEfficiencyStatement(creationDate, score, passed, assessedIdentity, resourceKey, courseTitle);
		} else {
			efficiencyStatementManager.createUserEfficiencyStatement(creationDate, score, passed, assessedIdentity, resource);
		}
		return Response.ok().build();
	}

}
