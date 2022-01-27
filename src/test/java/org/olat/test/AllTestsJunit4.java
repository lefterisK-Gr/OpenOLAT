/**
* OLAT - Online Learning and Training<br>
* http://www.olat.org
* <p>
* Licensed under the Apache License, Version 2.0 (the "License"); <br>
* you may not use this file except in compliance with the License.<br>
* You may obtain a copy of the License at
* <p>
* http://www.apache.org/licenses/LICENSE-2.0
* <p>
* Unless required by applicable law or agreed to in writing,<br>
* software distributed under the License is distributed on an "AS IS" BASIS, <br>
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. <br>
* See the License for the specific language governing permissions and <br>
* limitations under the License.
* <p>
* Copyright (c) since 2004 at Multimedia- & E-Learning Services (MELS),<br>
* University of Zurich, Switzerland.
* <hr>
* <a href="http://www.openolat.org">
* OpenOLAT - Online Learning and Training</a><br>
* This file has been modified by the OpenOLAT community. Changes are licensed
* under the Apache 2.0 license as the original file.
* <p>
*/
package org.olat.test;

/**
 * Description:<br>
 * JUnit suite runner
 * There are basically three types of tests:
 *** Tests that extend from the olatTestCase (testcase loads a full olat before running the tests -- very slow and is an integration test)
 *** Tests that load their own little spring context with @ContextConfiguration (that's how it should be done)
 *** Tests that do not need any Spring context
 * As tests with @ContextConfiguration can taint the context from olattestcase they must be placed on the end of the list!
 * <P>
 * Initial Date:  15.02.2010 <br>
 * @author guido
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	org.olat.core.util.i18n.I18nTest.class,
	// org.olat.core.util.mail.MailTest.class, // redisabled since mails are sent despite the fact that the whitelist is enabled
	org.olat.core.gui.components.table.MultiSelectColumnDescriptorTest.class,
	org.olat.core.gui.components.table.TableEventTest.class,
	org.olat.core.gui.components.table.TableMultiSelectEventTest.class,
	org.olat.core.gui.components.table.SorterTest.class,
	org.olat.core.commons.chiefcontrollers.ChiefControllerMessageEventTest.class,
	org.olat.core.util.vfs.VFSTest.class,
	org.olat.core.util.vfs.VFSManagerTest.class,
	org.olat.core.util.filter.impl.XSSFilterParamTest.class,
	org.olat.core.util.filter.impl.AddBaseURLToMediaRelativeURLFilterTest.class,
	org.olat.core.util.filter.impl.SimpleHTMLTagsFilterTest.class,
	org.olat.core.util.filter.impl.HtmlFilterTest.class,
	org.olat.core.util.filter.impl.HtmlMathScannerTest.class,
	org.olat.core.util.filter.impl.ConditionalHtmlCommentsFilterTest.class,
	org.olat.core.util.filter.impl.XMLValidCharacterFilterTest.class,
	org.olat.core.util.filter.impl.XMLValidEntityFilterTest.class,
	org.olat.core.helpers.SettingsTest.class,
	org.olat.core.util.coordinate.LockEntryTest.class,
	org.olat.modules.iq.DBPersistentLockManagerTest.class,
	org.olat.core.util.StringHelperTest.class,
	org.olat.core.util.FileUtilsTest.class,
	org.olat.core.util.FileNameSuffixFilterTest.class,
	org.olat.core.util.FormatterTest.class,
	org.olat.core.util.FormatLatexFormulasTest.class,
	org.olat.core.util.FormatterHourAndSecondsTest.class,
	org.olat.core.util.EncoderTest.class,
	org.olat.core.util.SimpleHtmlParserTest.class,
	org.olat.core.util.IPUtilsTest.class,
	org.olat.core.util.IPUtilsValidRangeTest.class,
	org.olat.core.util.ZipUtilTest.class,
	org.olat.core.util.ZipUtilConcatTest.class,
	org.olat.core.util.mail.EmailAddressValidatorTest.class,
	org.olat.core.util.mail.manager.MailManagerTest.class,
	org.olat.core.util.mail.manager.MailUserDataManagerTest.class,
	org.olat.core.util.openxml.OpenXmlWorkbookTest.class,
	org.olat.core.util.openxml.OpenXMLDocumentTest.class,
	org.olat.core.util.pdf.PdfDocumentTest.class,
	org.olat.core.util.xml.XMLDigitalSignatureUtilTest.class,
	org.olat.core.util.xml.XStreamHelperTest.class,
	org.olat.core.configuration.EDConfigurationTest.class,
	org.olat.core.id.context.BusinessControlFactoryTest.class,
	org.olat.core.id.context.HistoryManagerTest.class,
	org.olat.core.id.IdentityEnvironmentTest.class,
	org.olat.core.gui.render.VelocityTemplateTest.class,
	org.olat.core.gui.control.generic.iframe.IFrameDeliveryMapperTest.class,
	org.olat.note.NoteTest.class,
	org.olat.user.UserTest.class,
	org.olat.user.UserPropertiesTest.class,
	org.olat.commons.calendar.CalendarImportTest.class,
	org.olat.commons.calendar.CalendarUtilsTest.class,
	org.olat.commons.calendar.manager.ImportedCalendarDAOTest.class,
	org.olat.commons.calendar.manager.ImportedToCalendarDAOTest.class,
	org.olat.commons.calendar.manager.ICalFileCalendarManagerTest.class,
	org.olat.commons.calendar.manager.CalendarUserConfigurationDAOTest.class,
	org.olat.commons.lifecycle.LifeCycleManagerTest.class,
	org.olat.commons.coordinate.cluster.jms.JMSTest.class,
	org.olat.commons.coordinate.cluster.lock.LockTest.class,
	org.olat.commons.coordinate.CoordinatorTest.class,
	org.olat.core.commons.modules.glossary.GlossaryItemManagerTest.class,
	org.olat.core.commons.services.csp.manager.CSPManagerTest.class,
	org.olat.core.commons.services.doceditor.manager.DocEditorIdentityServiceTest.class,
	org.olat.core.commons.services.doceditor.manager.AccessDAOTest.class,
	org.olat.core.commons.services.doceditor.onlyoffice.restapi.OnlyOfficeWebServiceTest.class,
	org.olat.core.commons.services.vfs.manager.VFSXStreamTest.class,
	org.olat.core.commons.services.vfs.manager.VFSMetadataDAOTest.class,
	org.olat.core.commons.services.vfs.manager.VFSRevisionDAOTest.class,
	org.olat.core.commons.services.vfs.manager.VFSStatsDAOTest.class,
	org.olat.core.commons.services.vfs.manager.VFSThumbnailDAOTest.class,
	org.olat.core.commons.services.vfs.manager.VFSRepositoryServiceTest.class,
	org.olat.core.commons.services.vfs.manager.VFSRepositoryModuleTest.class,
	org.olat.core.commons.services.vfs.manager.VFSLockManagerTest.class,
	org.olat.core.commons.services.vfs.manager.VFSVersioningTest.class,
	org.olat.core.commons.services.help.ConfluenceHelperTest.class,
	org.olat.core.commons.services.help.spi.ConfluenceLinkSPITest.class,
	org.olat.core.commons.services.license.manager.LicenseTypeActivationDAOTest.class,
	org.olat.core.commons.services.license.manager.LicenseTypeDAOTest.class,
	org.olat.core.commons.services.license.manager.ResourceLicenseDAOTest.class,
	org.olat.core.commons.services.webdav.WebDAVCommandsTest.class,
	org.olat.core.commons.services.webdav.manager.DigestAuthenticationTest.class,
	org.olat.core.commons.services.webdav.manager.WebDAVManagerTest.class,
	org.olat.core.commons.services.webdav.manager.WebDAVAuthManagerTest.class,
	org.olat.core.commons.services.webdav.servlets.RequestUtilsTest.class,
	org.olat.core.commons.services.sms.manager.MessageLogDAOTest.class,
	org.olat.core.commons.services.taskexecutor.manager.PersistentTaskDAOTest.class,
	org.olat.core.commons.services.taskexecutor.manager.TaskExecutorManagerTest.class,
	org.olat.core.commons.services.text.TextServiceTest.class,
	org.olat.group.BusinessGroupManagedFlagsTest.class,
	org.olat.group.test.BGRightManagerTest.class,
	org.olat.group.test.BGAreaManagerTest.class,
	org.olat.group.test.BusinessGroupServiceTest.class,
	org.olat.group.test.BusinessGroupDAOTest.class,
	org.olat.group.test.BusinessGroupRelationDAOTest.class,
	org.olat.group.test.BusinessGroupConcurrentTest.class,
	org.olat.group.test.ContactDAOTest.class,
	org.olat.group.test.BusinessGroupMembershipProcessorTest.class,
	org.olat.fileresource.FileResourceTest.class,
	org.olat.resource.lock.pessimistic.PLockTest.class,
	org.olat.resource.references.ReferenceManagerTest.class,
	org.olat.resource.OLATResourceManagerTest.class,
	org.olat.basesecurity.manager.AuthenticationDAOTest.class,
	org.olat.basesecurity.manager.AuthenticationHistoryDAOTest.class,
	org.olat.basesecurity.manager.GroupDAOTest.class,
	org.olat.basesecurity.manager.IdentityDAOTest.class,
	org.olat.basesecurity.manager.RelationRightDAOTest.class,
	org.olat.basesecurity.manager.RelationRoleDAOTest.class,
	org.olat.basesecurity.manager.IdentityToIdentityRelationDAOTest.class,
	org.olat.basesecurity.GetIdentitiesByPowerSearchTest.class,
	org.olat.basesecurity.BaseSecurityManagerTest.class,
	org.olat.user.UserDAOTest.class,
	org.olat.user.UserManagerTest.class,
	org.olat.user.manager.UserDataExportDAOTest.class,
	org.olat.user.manager.UserDataExportServiceTest.class,
	org.olat.user.manager.UserDataDeleteDAOTest.class,
	org.olat.user.manager.AbsenceLeaveDAOTest.class,
	org.olat.user.manager.lifecycle.UserLifecycleManagerTest.class,
	org.olat.repository.manager.AutomaticLifecycleServiceTest.class,
	org.olat.repository.ui.catalog.CatalogManagerTest.class,
	org.olat.repository.manager.RepositoryEntryDAOTest.class,
	org.olat.repository.manager.RepositoryEntryLifecycleDAOTest.class,
	org.olat.repository.manager.RepositoryEntryRelationDAOTest.class,
	org.olat.repository.manager.RepositoryServiceImplTest.class,
	org.olat.repository.manager.RepositoryEntryStatisticsDAOTest.class,
	org.olat.repository.manager.RepositoryEntryAuthorQueriesTest.class,
	org.olat.repository.manager.RepositoryEntryMyCourseQueriesTest.class,
	org.olat.repository.manager.RepositoryEntryMembershipProcessorTest.class,
	org.olat.repository.manager.RepositoryEntryToOrganisationDAOTest.class,
	org.olat.repository.manager.RepositoryEntryToTaxonomyLevelDAOTest.class,
	org.olat.repository.manager.RepositoryEntryEducationalTypeDAOTest.class,
	org.olat.repository.manager.RepositoryEntryQueriesTest.class,
	org.olat.repository.RepositoryManagerTest.class,
	org.olat.repository.RepositoryEntryImportExportTest.class,
	org.olat.repository.wizard.RepositoryWizardServiceTest.class,
	org.olat.instantMessaging.InstantMessageDAOTest.class,
	org.olat.instantMessaging.InstantMessagePreferencesDAOTest.class,
	org.olat.instantMessaging.RosterDAOTest.class,
	org.olat.instantMessaging.InstantMessageServiceTest.class,
	org.olat.core.commons.services.image.spi.ImageHelperImplTest.class,
	org.olat.course.archiver.FormatConfigHelperTest.class,
	org.olat.course.condition.ConditionTest.class,
	org.olat.course.condition.GetPassedTest.class,
	org.olat.course.condition.KeyAndNameConverterTest.class,
	org.olat.course.condition.interpreter.EvalUserPropertyFunctionTest.class,
	org.olat.course.disclaimer.CourseDisclaimerManagerTest.class,
	org.olat.course.highscore.HighScoreManagerTest.class,
	org.olat.course.learningpath.LearningPathServiceTest.class,
	org.olat.course.nodes.dialog.manager.DialogElementsManagerTest.class,
	org.olat.course.nodes.en.EnrollmentManagerSerialTest.class,
	org.olat.course.nodes.en.EnrollmentManagerConcurrentTest.class,
	org.olat.course.nodes.form.FormManagerTest.class,
	org.olat.course.nodes.form.rule.FormParticipationRuleSPITest.class,
	org.olat.course.nodes.gta.manager.GTAManagerTest.class,
	org.olat.course.nodes.gta.manager.GTATaskRevisionDAOTest.class,
	org.olat.course.nodes.gta.manager.GTAIdentityMarkDAOTest.class,
	org.olat.course.nodes.gta.rule.GTAReminderRuleTest.class,
	org.olat.course.nodes.livestream.manager.LaunchDAOTest.class,
	org.olat.course.nodes.livestream.manager.UrlTemplateDAOTest.class,
	org.olat.course.nodes.members.manager.MembersManagerTest.class,
	org.olat.course.nodes.pf.manager.PFManagerTest.class,
	org.olat.course.nodes.ProjectBrokerCourseNodeTest.class,
	org.olat.course.assessment.AssessmentManagerTest.class,
	org.olat.course.assessment.manager.UserCourseInformationsManagerTest.class,
	org.olat.course.assessment.manager.AssessmentModeManagerTest.class,
	org.olat.course.reminder.manager.ReminderRuleDAOTest.class,
	org.olat.course.reminder.manager.ReminderRulesXStreamTest.class,
	org.olat.course.run.scoring.AssessmentAccountingTest.class,
	org.olat.course.statistic.DailyStatisticUpdateManagerTest.class,
	org.olat.course.statistic.DayOfWeekStatisticUpdateManagerTest.class,
	org.olat.course.statistic.HourOfDayStatisticUpdateManagerTest.class,
	// org.olat.course.statistic.WeeklyStatisticUpdateManagerTest.class,
	org.olat.modules.assessment.manager.AssessmentEntryDAOTest.class,
	org.olat.course.certificate.manager.CertificatesManagerTest.class,
	org.olat.course.config.CourseConfigManagerImplTest.class,
	org.olat.course.config.ui.courselayout.CustomConfigManagerTest.class,
	org.olat.course.groupsandrights.CourseGroupManagementTest.class,
	org.olat.course.editor.PublishProcessTest.class,
	org.olat.course.CourseXStreamAliasesTest.class,
	org.olat.course.wizard.CourseWizardServiceTest.class,
	org.olat.modules.adobeconnect.manager.AdobeConnectProviderTest.class,
	org.olat.modules.adobeconnect.manager.AdobeConnectUserDAOTest.class,
	org.olat.modules.adobeconnect.manager.AdobeConnectMeetingDAOTest.class,
	org.olat.modules.adobeconnect.manager.AdobeConnectUtilsTest.class,
	org.olat.modules.appointments.AppointmentsServiceTest.class,
	org.olat.modules.appointments.manager.AppointmentDAOTest.class,
	org.olat.modules.appointments.manager.OrganizerDAOTest.class,
	org.olat.modules.appointments.manager.ParticipationDAOTest.class,
	org.olat.modules.appointments.manager.TopicDAOTest.class,
	org.olat.modules.appointments.manager.TopicToGroupDAOTest.class,
	org.olat.modules.appointments.ui.DuplicateTopicCallbackTest.class,
	org.olat.modules.bigbluebutton.manager.BigBlueButtonServerDAOTest.class,
	org.olat.modules.bigbluebutton.manager.BigBlueButtonMeetingDAOTest.class,
	org.olat.modules.bigbluebutton.manager.BigBlueButtonAttendeeDAOTest.class,
	org.olat.modules.bigbluebutton.manager.BigBlueButtonMeetingTemplateDAOTest.class,
	org.olat.modules.bigbluebutton.manager.BigBlueButtonRecordingReferenceDAOTest.class,
	org.olat.modules.bigbluebutton.manager.BigBlueButtonUriBuilderTest.class,
	org.olat.modules.bigbluebutton.manager.BigBlueButtonMeetingQueriesTest.class,
	org.olat.modules.bigbluebutton.manager.BigBlueButtonManagerTest.class,
	org.olat.modules.contacttracing.manager.ContactTracingLocationDAOTest.class,
	org.olat.modules.contacttracing.manager.ContactTracingRegistrationDAOTest.class,
	org.olat.modules.dcompensation.manager.DisadvantageCompensationDAOTest.class,
	org.olat.modules.dcompensation.manager.DisadvantageCompensationAuditLogDAOTest.class,
	org.olat.modules.iq.IQManagerTest.class,
	org.olat.modules.fo.ForumManagerTest.class,//fail
	org.olat.modules.wiki.WikiUnitTest.class,
	org.olat.modules.wiki.WikiManagerTest.class,
	org.olat.modules.wiki.versioning.diff.CookbookDiffTest.class,
	org.olat.modules.wiki.gui.components.wikiToHtml.FilterUtilTest.class,
	org.olat.modules.coach.manager.CoachingDAOTest.class,
	org.olat.modules.coach.CoachingLargeTest.class,
	org.olat.modules.curriculum.manager.CurriculumDAOTest.class,
	org.olat.modules.curriculum.manager.CurriculumMemberQueriesTest.class,
	org.olat.modules.curriculum.manager.CurriculumElementDAOTest.class,
	org.olat.modules.curriculum.manager.CurriculumElementTypeDAOTest.class,
	org.olat.modules.curriculum.manager.CurriculumRepositoryEntryRelationDAOTest.class,
	org.olat.modules.curriculum.manager.CurriculumElementToTaxonomyLevelDAOTest.class,
	org.olat.modules.curriculum.manager.CurriculumServiceTest.class,
	org.olat.modules.docpool.manager.DocumentPoolManagerTest.class,
	org.olat.modules.forms.manager.EvaluationFormParticipationDAOTest.class,
	org.olat.modules.forms.manager.EvaluationFormReportDAOTest.class,
	org.olat.modules.forms.manager.EvaluationFormResponseDAOTest.class,
	org.olat.modules.forms.manager.EvaluationFormSessionDAOTest.class,
	org.olat.modules.forms.manager.EvaluationFormStorageTest.class,
	org.olat.modules.forms.manager.EvaluationFormSurveyDAOTest.class,
	org.olat.modules.forms.model.jpa.SurveysFilterTest.class,
	org.olat.modules.gotomeeting.manager.GoToJsonUtilTest.class,
	org.olat.modules.gotomeeting.manager.GoToMeetingDAOTest.class,
	org.olat.modules.gotomeeting.manager.GoToOrganizerDAOTest.class,
	org.olat.modules.gotomeeting.manager.GoToRegistrantDAOTest.class,
	org.olat.modules.gotomeeting.GoToTimezoneIDsTest.class,
	org.olat.modules.grading.manager.GraderToIdentityDAOTest.class,
	org.olat.modules.grading.manager.GradingAssignmentDAOTest.class,
	org.olat.modules.grading.manager.GradingConfigurationDAOTest.class,
	org.olat.modules.grading.manager.GradingTimeRecordDAOTest.class,
	org.olat.modules.grading.manager.GradingServiceTest.class,
	org.olat.basesecurity.manager.OrganisationDAOTest.class,
	org.olat.basesecurity.manager.OrganisationTypeDAOTest.class,
	org.olat.basesecurity.manager.OrganisationTypeToTypeDAOTest.class,
	org.olat.basesecurity.manager.OrganisationServiceTest.class,
	org.olat.basesecurity.manager.SecurityGroupDAOTest.class,
	org.olat.modules.appointments.ui.StartDurationTest.class,
	org.olat.modules.ceditor.ContentEditorXStreamTest.class,
	org.olat.modules.ceditor.model.ContainerSettingsTest.class,
	org.olat.modules.edusharing.manager.EdusharingUsageDAOTest.class,
	org.olat.modules.portfolio.manager.BinderDAOTest.class,
	org.olat.modules.portfolio.manager.CategoryDAOTest.class,
	org.olat.modules.portfolio.manager.MediaDAOTest.class,
	org.olat.modules.portfolio.manager.PageDAOTest.class,
	org.olat.modules.portfolio.manager.AssignmentDAOTest.class,
	org.olat.modules.portfolio.manager.SharedByMeQueriesTest.class,
	org.olat.modules.portfolio.manager.SharedWithMeQueriesTest.class,
	org.olat.modules.portfolio.manager.PortfolioServiceTest.class,
	org.olat.modules.portfolio.manager.PortfolioPageToTaxonomyCompetenceDAOTest.class,
	org.olat.modules.portfolio.manager.BinderUserInformationsDAOTest.class,
	org.olat.modules.portfolio.manager.InvitationDAOTest.class,
	org.olat.modules.portfolio.manager.MetadataXStreamTest.class,
	org.olat.modules.portfolio.handler.BinderXStreamTest.class,
	org.olat.modules.quality.analysis.manager.AnalysisFilterDAOTest.class,
	org.olat.modules.quality.analysis.manager.AnalysisPresentationDAOTest.class,
	org.olat.modules.quality.analysis.manager.EvaluationFormDAOTest.class,
	org.olat.modules.quality.generator.manager.QualityGeneratorDAOTest.class,
	org.olat.modules.quality.generator.manager.QualityGeneratorConfigDAOTest.class,
	org.olat.modules.quality.generator.manager.titlecreator.CurriculumElementHandlerTest.class,
	org.olat.modules.quality.generator.manager.titlecreator.RepositoryEntryHandlerTest.class,
	org.olat.modules.quality.generator.manager.titlecreator.UserHandlerTest.class,
	org.olat.modules.quality.generator.provider.course.manager.CourseProviderDAOTest.class,
	org.olat.modules.quality.generator.provider.course.CourseProviderTest.class,
	org.olat.modules.quality.generator.provider.courselectures.manager.CourseLecturesProviderDAOTest.class,
	org.olat.modules.quality.generator.provider.courselectures.CourseLecturesProviderTest.class,
	org.olat.modules.quality.generator.provider.curriculumelement.manager.CurriculumElementProviderDAOTest.class,
	org.olat.modules.quality.generator.provider.curriculumelement.CurriculumElementProviderTest.class,
	org.olat.modules.quality.manager.AudiencelessQualityContextBuilderTest.class,
	org.olat.modules.quality.manager.CurriculumElementQualityContextBuilderTest.class,
	org.olat.modules.quality.manager.DefaultQualityContextBuilderTest.class,
	org.olat.modules.quality.manager.QualityContextDAOTest.class,
	org.olat.modules.quality.manager.QualityContextToCurriculumDAOTest.class,
	org.olat.modules.quality.manager.QualityContextToCurriculumElementDAOTest.class,
	org.olat.modules.quality.manager.QualityContextToOrganisationDAOTest.class,
	org.olat.modules.quality.manager.QualityContextToTaxonomyLevelDAOTest.class,
	org.olat.modules.quality.manager.QualityDataCollectionDAOTest.class,
	org.olat.modules.quality.manager.QualityParticipationDAOTest.class,
	org.olat.modules.quality.manager.QualityReminderDAOTest.class,
	org.olat.modules.quality.manager.QualityReportAccessDAOTest.class,
	org.olat.modules.quality.manager.RepositoryEntryQualityContextBuilderTest.class,
	org.olat.modules.lecture.manager.AbsenceCategoryDAOTest.class,
	org.olat.modules.lecture.manager.AbsenceNoticeDAOTest.class,
	org.olat.modules.lecture.manager.AbsenceNoticeToLectureBlockDAOTest.class,
	org.olat.modules.lecture.manager.AbsenceNoticeToRepositoryEntryDAOTest.class,
	org.olat.modules.lecture.manager.LectureBlockDAOTest.class,
	org.olat.modules.lecture.manager.LectureBlockRollCallDAOTest.class,
	org.olat.modules.lecture.manager.LectureBlockToTaxonomyLevelDAOTest.class,
	org.olat.modules.lecture.manager.LectureParticipantSummaryDAOTest.class,
	org.olat.modules.lecture.manager.LectureServiceTest.class,
	org.olat.modules.lecture.manager.ReasonDAOTest.class,
	org.olat.modules.lecture.manager.LectureBlockReminderDAOTest.class,
	org.olat.modules.lecture.manager.RepositoryEntryLectureConfigurationDAOTest.class,
	org.olat.modules.lecture.manager.LectureBlockAuditLogDAOTest.class,
	org.olat.modules.lecture.ui.blockimport.BlockConverterTest.class,
	org.olat.modules.lecture.ui.ParticipantLecturesOverviewControllerTest.class,
	org.olat.modules.reminder.ReminderModuleTest.class,
	org.olat.modules.reminder.manager.ReminderDAOTest.class,
	org.olat.modules.reminder.manager.ReminderRuleEngineTest.class,
	org.olat.modules.reminder.manager.ReminderRulesXStreamTest.class,
	org.olat.modules.taxonomy.manager.TaxonomyDAOTest.class,
	org.olat.modules.taxonomy.manager.TaxonomyLevelDAOTest.class,
	org.olat.modules.taxonomy.manager.TaxonomyLevelTypeDAOTest.class,
	org.olat.modules.taxonomy.manager.TaxonomyCompetenceDAOTest.class,
	org.olat.modules.taxonomy.manager.TaxonomyCompetenceAuditLogDAOTest.class,
	org.olat.modules.teams.manager.TeamsMeetingDAOTest.class,
	org.olat.modules.teams.manager.TeamsMeetingQueriesTest.class,
	org.olat.modules.teams.manager.TeamsUserDAOTest.class,
	org.olat.modules.teams.manager.TeamsAttendeeDAOTest.class,
	org.olat.modules.teams.manager.MicrosoftGraphDAOTest.class,
	org.olat.modules.video.VideoFormatTest.class,
	org.olat.modules.video.manager.VideoTranscodingDAOTest.class,
	org.olat.modules.video.manager.VideoMetadataDAOTest.class,
	org.olat.modules.video.manager.VideoXStreamTest.class,
	org.olat.modules.video.manager.VideoMetaXStreamTest.class,
	org.olat.modules.video.manager.VideoManagerTest.class,
	org.olat.modules.video.spi.youtube.YoutubeProviderTest.class,
	org.olat.modules.video.spi.youtube.YoutubeVideoIdTest.class,
	org.olat.modules.webFeed.dispatching.PathTest.class,
	org.olat.modules.webFeed.manager.FeedDAOTest.class,
	org.olat.modules.webFeed.manager.ItemDAOTest.class,
	org.olat.modules.webFeed.manager.FeedFileStorgeTest.class,
	org.olat.properties.PropertyTest.class,
	org.olat.search.service.document.file.FileDocumentFactoryTest.class,
	org.olat.search.service.indexer.repository.course.SPCourseNodeIndexerTest.class,
	org.olat.search.service.document.file.HtmlDocumentTest.class,
	org.olat.search.service.document.file.PDFDocumentTest.class,
	org.olat.search.service.document.file.OfficeDocumentTest.class,
	org.olat.core.commons.services.notifications.manager.NotificationsManagerTest.class,
	org.olat.registration.RegistrationManagerTest.class,
	org.olat.course.nodes.projectbroker.ProjectBrokerManagerTest.class,
	org.olat.core.commons.persistence.DBTest.class,
	org.olat.modules.ims.cp.CPManagerTest.class,
	org.olat.modules.ims.cp.ImsCPHandlerTest.class,
	org.olat.modules.ims.qti.fileresource.FileResourceValidatorTest.class,
	org.olat.ims.qti.QTIResultManagerTest.class,
	org.olat.ims.qti.qpool.QTIImportProcessorTest.class,
	org.olat.ims.qti.qpool.QTIExportProcessorTest.class,
	org.olat.ims.qti.qpool.ItemFileResourceValidatorTest.class,
	org.olat.ims.qti.questionimport.CSVToQuestionConverterTest.class,
	org.olat.ims.qti.statistics.manager.QTIStatisticsManagerLargeTest.class,
	org.olat.ims.qti.statistics.manager.QTIStatisticsManagerTest.class,
	org.olat.ims.qti.statistics.manager.StatisticsTest.class,
	org.olat.ims.qti21.manager.AssessmentTestSessionDAOTest.class,
	org.olat.ims.qti21.manager.AssessmentItemSessionDAOTest.class,
	org.olat.ims.qti21.manager.AssessmentResponseDAOTest.class,
	org.olat.ims.qti21.manager.CorrectResponsesUtilTest.class,
	org.olat.ims.qti21.manager.QTI21ServiceTest.class,
	org.olat.ims.qti21.model.xml.AssessmentItemBuilderTest.class,
	org.olat.ims.qti21.model.xml.MultipleChoiceAssessmentItemBuilderTest.class,
	org.olat.ims.qti21.model.xml.SingleChoiceAssessmentItemBuilderTest.class,
	org.olat.ims.qti21.model.xml.TestFeedbackBuilderTest.class,
	org.olat.ims.qti21.model.xml.HottextAssessmentItemBuilderTest.class,
	org.olat.ims.qti21.model.xml.OrderAssessmentItemBuilderTest.class,
	org.olat.ims.qti21.model.xml.FIBAssessmentItemBuilderTest.class,
	org.olat.ims.qti21.model.xml.AssessmentHtmlBuilderTest.class,
	org.olat.ims.qti21.model.xml.AssessmentItemPackageTest.class,
	org.olat.ims.qti21.model.xml.ManifestPackageTest.class,
	org.olat.ims.qti21.pool.QTI12To21ConverterTest.class,
	org.olat.ims.qti21.pool.QTI12To21HtmlHandlerTest.class,
	org.olat.ims.qti21.pool.QTI21QPoolServiceProviderTest.class,
	org.olat.ims.qti21.repository.handlers.QTI21AssessmentTestHandlerTest.class,
	org.olat.ims.qti21.statistics.TextEntryInteractionStatisticsTest.class,
	org.olat.ims.qti21.model.xml.Onyx38ToQtiWorksAssessementItemsTest.class,
	org.olat.ims.qti21.model.xml.OnyxToQtiWorksAssessementItemsTest.class,
	org.olat.ims.qti21.model.xml.OnyxToQtiWorksAssessementTestsTest.class,
	org.olat.ims.qti21.model.xml.OnyxToAssessmentItemBuilderTest.class,
	org.olat.ims.qti21.model.xml.OpenOLATAssessementItemsTest.class,
	org.olat.ims.qti21.model.xml.QTI21ExplorerHandlerTest.class,
	org.olat.ims.qti21.ui.components.AssessmentRenderFunctionsTest.class,
	org.olat.ims.qti21.ui.AssessmentTestSessionComparatorTest.class,
	org.olat.ims.qti21.questionimport.CSVToAssessmentItemConverterTest.class,
	org.olat.ims.lti.LTIManagerTest.class,
	org.olat.ims.lti13.LTI13ServiceTest.class,
	org.olat.ims.lti13.LTI13JsonUtilTest.class,
	org.olat.ims.lti13.manager.LTI13KeyDAOTest.class,
	org.olat.ims.lti13.manager.LTI13PlatformDAOTest.class,
	org.olat.ims.lti13.manager.LTI13RequestUtilTest.class,
	org.olat.ims.lti13.manager.LTI13SharedToolDeploymentDAOTest.class,
	org.olat.ims.lti13.manager.LTI13SharedToolServiceDAOTest.class,
	org.olat.ims.lti13.manager.LTI13ToolDAOTest.class,
	org.olat.ims.lti13.manager.LTI13ToolDeploymentDAOTest.class,
	org.olat.ims.lti13.manager.LTI13AssessmentEntryDAOTest.class,
	org.olat.ims.lti13.manager.LTI13ExternalToolSigningKeyResolverTest.class,
	org.olat.modules.qpool.manager.MetadataConverterHelperTest.class,
	org.olat.modules.qpool.manager.QuestionDAOTest.class,
	org.olat.modules.qpool.manager.FileStorageTest.class,
	org.olat.modules.qpool.manager.CollectionDAOTest.class,
	org.olat.modules.qpool.manager.QLicenseDAOTest.class,
	org.olat.modules.qpool.manager.QItemTypeDAOTest.class,
	org.olat.modules.qpool.manager.QEducationalContextDAOTest.class,
	org.olat.modules.qpool.manager.PoolDAOTest.class,
	org.olat.modules.qpool.manager.QItemQueriesDAOTest.class,
	org.olat.modules.qpool.manager.QuestionPoolServiceTest.class,
	org.olat.modules.qpool.manager.QuestionItemAuditLogDAOTest.class,
	org.olat.login.oauth.OAuthDispatcherTest.class,
	org.olat.login.oauth.ADFSProviderTest.class,
	org.olat.ldap.LDAPLoginTest.class,
	org.olat.ldap.manager.LDAPLoginManagerTest.class,
	org.olat.core.commons.services.mark.MarksTest.class,
	org.olat.test.SpringInitDestroyVerficationTest.class,
	//org.olat.course.statistic.weekly.TestWeeklyStatisticManager_fillGaps.class, don't know what it tests
	org.olat.core.commons.services.commentAndRating.manager.UserCommentsDAOTest.class,
	org.olat.core.commons.services.commentAndRating.manager.UserRatingsDAOTest.class,
	org.olat.course.auditing.UserNodeAuditManagerTest.class,
	org.olat.course.noderight.manager.NodeRightServiceImplTest.class,
	org.olat.shibboleth.handler.SpringShibbolethAttributeHandlerFactoryTest.class,
	org.olat.core.CoreSpringFactoryTest.class,
	org.olat.modules.openmeetings.OpenMeetingsTest.class,
	org.olat.modules.openmeetings.manager.OpenMeetingsDAOTest.class,
	org.olat.commons.info.InfoManagerTest.class,
	org.olat.core.commons.services.tagging.SimpleTagProposalManagerTest.class,
	org.olat.core.commons.services.tagging.TaggingManagerTest.class,
	org.olat.core.dispatcher.DispatcherModuleRedirectTest.class,
	org.olat.core.dispatcher.mapper.MapperDAOTest.class,
	org.olat.core.dispatcher.mapper.MapperServiceTest.class,
	org.olat.restapi.AuthenticationTest.class,
	org.olat.restapi.BigBlueButtonStatsWebServiceTest.class,
	org.olat.restapi.BigBlueButtonServerWebServiceTest.class,
	org.olat.restapi.BigBlueButtonTemplatesWebServiceTest.class,
	org.olat.restapi.CatalogTest.class,
	org.olat.restapi.CalendarTest.class,
	org.olat.restapi.CertificationTest.class,
	org.olat.restapi.UserCertificationWebServiceTest.class,
	org.olat.restapi.CourseGroupMgmtTest.class,
	org.olat.restapi.CourseCalendarTest.class,
	org.olat.restapi.CourseDBTest.class,
	org.olat.restapi.CoursesContactElementTest.class,
	org.olat.restapi.CourseSecurityTest.class,
	org.olat.restapi.CoursesElementsTest.class,
	org.olat.restapi.CoursesFoldersTest.class,
	org.olat.restapi.CoursesForumsTest.class,
	org.olat.restapi.CoursesQTIElementTest.class,
	org.olat.restapi.CoursesResourcesFoldersTest.class,
	org.olat.restapi.CoursesTest.class,
	org.olat.restapi.CoursePublishTest.class,
	org.olat.restapi.CoursesInfosTest.class,
	org.olat.restapi.CourseTest.class,
	org.olat.restapi.CurriculumsWebServiceTest.class,
	org.olat.restapi.CurriculumElementsWebServiceTest.class,
	org.olat.restapi.CurriculumElementTypesWebServiceTest.class,
	org.olat.restapi.DocEditorWebServiceTest.class,
	org.olat.restapi.EfficiencyStatementTest.class,
	org.olat.restapi.UserEfficiencyStatementWebServiceTest.class,
	org.olat.restapi.FolderTest.class,
	org.olat.restapi.ForumTest.class,
	org.olat.restapi.GradingWebServiceTest.class,
	org.olat.restapi.GroupFoldersTest.class,
	org.olat.restapi.GroupMgmtTest.class,
	org.olat.restapi.I18nTest.class,
	org.olat.restapi.MyForumsTest.class,
	org.olat.restapi.LecturesBlocksTest.class,
	org.olat.restapi.LecturesBlocksRootTest.class,
	org.olat.restapi.LecturesBlockRollCallTest.class,
	org.olat.restapi.NotificationsTest.class,
	org.olat.restapi.NotificationsSubscribersTest.class,
	org.olat.restapi.RelationRolesWebServiceTest.class,
	org.olat.restapi.IdentityToIdentityRelationsWebServiceTest.class,
	org.olat.restapi.RepositoryEntryLifecycleTest.class,
	org.olat.restapi.RepositoryEntriesTest.class,
	org.olat.restapi.RepositoryEntryWebServiceTest.class,
	org.olat.restapi.RemindersWebServiceTest.class,
	org.olat.restapi.RestApiLoginFilterTest.class,
	org.olat.restapi.UserAuthenticationMgmtTest.class,
	org.olat.restapi.UserAuthenticationsWebServiceTest.class,
	org.olat.restapi.UserFoldersTest.class,
	org.olat.restapi.UserCoursesTest.class,
	org.olat.restapi.UserMgmtTest.class,
	org.olat.restapi.ContactsTest.class,
	org.olat.restapi.SharedFolderTest.class,
	org.olat.restapi.SystemTest.class,
	org.olat.restapi.ChangePasswordTest.class,
	org.olat.restapi.QuestionPoolTest.class,
	org.olat.restapi.OrganisationsWebServiceTest.class,
	org.olat.restapi.OrganisationTypesWebServiceTest.class,
	org.olat.restapi.RegistrationTest.class,
	org.olat.restapi.DocumentPoolModuleWebServiceTest.class,
	org.olat.restapi.TaxonomyWebServiceTest.class,
	org.olat.restapi.security.RestSecurityBeanTest.class,
	de.bps.olat.portal.institution.InstitutionPortletTest.class,
	de.bps.olat.portal.links.LinksPortletTest.class,
	de.bps.olat.user.ChangeEMailExecuteControllerTest.class,
	de.bps.course.nodes.ChecklistCourseNodeTest.class,
	org.olat.group.manager.BusinessGroupImportExportXStreamTest.class,
	org.olat.group.test.BusinessGroupImportExportTest.class,
	org.olat.resource.accesscontrol.ACFrontendManagerTest.class,
	org.olat.resource.accesscontrol.ACMethodManagerTest.class,
	org.olat.resource.accesscontrol.ACOfferManagerTest.class,
	org.olat.resource.accesscontrol.ACOrderManagerTest.class,
	org.olat.resource.accesscontrol.ACTransactionManagerTest.class,
	org.olat.resource.accesscontrol.ACReservationDAOTest.class,
	org.olat.resource.accesscontrol.provider.auto.AutoAccessManagerTest.class,
	org.olat.resource.accesscontrol.provider.auto.manager.AdvanceOrderDAOTest.class,
	org.olat.resource.accesscontrol.provider.paypalcheckout.manager.PaypalCheckoutManagerTest.class,
	org.olat.resource.accesscontrol.provider.paypalcheckout.manager.PaypalCheckoutTransactionDAOTest.class,
	/**
	 * Pure JUnit test without need of framework
	 */
	org.olat.core.commons.services.doceditor.onlyoffice.manager.OnlyOfficeSecurityServiceImplTest.class,
	org.olat.core.commons.services.doceditor.onlyoffice.manager.OnlyOfficeServiceImplTest.class,
	org.olat.core.commons.services.doceditor.discovery.manager.DiscoveryServiceImplTest.class,
	org.olat.core.commons.services.doceditor.discovery.manager.DiscoveryXStreamTest.class,
	org.olat.core.commons.services.commentAndRating.manager.CommentAndRatingServiceTest.class,
	org.olat.core.commons.services.license.ui.LicenseSelectionConfigTest.class,
	org.olat.core.gui.components.form.flexible.impl.elements.richText.TextModeTest.class,
	org.olat.core.gui.components.form.flexible.impl.elements.SelectboxSelectionImplTest.class,
	org.olat.core.gui.components.form.flexible.impl.elements.SingleSelectionImplTest.class,
	org.olat.core.gui.components.form.flexible.impl.elements.TextElementRendererTest.class,
	org.olat.core.util.DateUtilsTest.class,
	org.olat.core.util.tree.TreeHelperTest.class,
	org.olat.core.util.resource.OresHelperTest.class,
	org.olat.course.learningpath.evaluation.ConfigEndDateEvaluatorTest.class,
	org.olat.course.learningpath.evaluation.ConfigStartDateEvaluatorTest.class,
	org.olat.course.learningpath.evaluation.DefaultLearningPathStatusEvaluatorTest.class,
	org.olat.course.learningpath.evaluation.LinearAccessEvaluatorTest.class,
	org.olat.course.learningpath.manager.LearningPathNodeAccessProviderTest.class,
	org.olat.course.nodes.st.assessment.PassCounterTest.class,
	org.olat.course.nodes.st.assessment.CumulatingDurationEvaluatorTest.class,
	org.olat.course.nodes.st.assessment.CumulatingScoreEvaluatorTest.class,
	org.olat.course.nodes.st.assessment.ConventionalSTCompletionEvaluatorTest.class,
	org.olat.course.nodes.st.assessment.MandatoryObligationEvaluatorTest.class,
	org.olat.course.nodes.st.assessment.MaxScoreCumulatorTest.class,
	org.olat.course.nodes.st.assessment.STFullyAssessedEvaluatorTest.class,
	org.olat.course.nodes.st.assessment.STLastModificationsEvaluatorTest.class,
	org.olat.course.nodes.st.assessment.STRootPassedEvaluatorTest.class,
	org.olat.course.nodes.st.assessment.STLearningPathStatusEvaluatorTest.class,
	org.olat.course.run.scoring.AverageCompletionEvaluatorTest.class,
	org.olat.course.run.userview.UserCourseEnvironmentImplTest.class,
	org.olat.login.validation.PasswordSyntaxValidatorTest.class,
	org.olat.login.validation.PasswordValidationRuleFactoryTest.class,
	org.olat.modules.assessment.model.OverridableImplTest.class,
	org.olat.modules.card2brain.manager.Card2BrainManagerImplTest.class,
	org.olat.modules.ceditor.CloneElementHandlerTest.class,
	org.olat.modules.edubase.manager.EdubaseManagerImplTest.class,
	org.olat.modules.edusharing.manager.EdusharingHtmlServiceImplTest.class,
	org.olat.modules.edusharing.manager.EdusharingSecurityImplTest.class,
	org.olat.modules.fo.WordCountTest.class,
	org.olat.modules.forms.manager.EvaluationFormMangerImplTest.class,
	org.olat.modules.forms.manager.RubricStatisticCalculatorTest.class,
	org.olat.modules.forms.model.xml.ScaleTypeTest.class,
	org.olat.modules.forms.model.xml.FormTest.class,
	org.olat.modules.forms.RubricsComparisonTest.class,
	org.olat.modules.opencast.WildcardFilterTest.class,
	org.olat.modules.qpool.manager.QuestionPoolServiceImplTest.class,
	org.olat.modules.qpool.manager.QuestionPoolUserDataDeletableTest.class,
	org.olat.modules.qpool.manager.review.LowerLimitProviderTest.class,
	org.olat.modules.qpool.manager.review.ReviewServiceImplTest.class,
	org.olat.modules.qpool.model.QuestionItemAuditLogBuilderImplTest.class,
	org.olat.modules.qpool.ui.metadata.QPoolTaxonomyTreeBuilderTest.class,
	org.olat.modules.quality.analysis.manager.AnalysisPresentationXStreamTest.class,
	org.olat.modules.quality.analysis.manager.StatisticsCalculatorTest.class,
	org.olat.modules.quality.analysis.MultiTrendSeriesTest.class,
	org.olat.modules.quality.analysis.TemporalKeyComparatorTest.class,
	org.olat.modules.quality.generator.provider.ProviderHelperTest.class,
	org.olat.modules.quality.manager.QualityServiceImplTest.class,
	org.olat.modules.webFeed.manager.FeedManagerImplTest.class,
	org.olat.modules.webFeed.manager.RomeFeedFetcherTest.class,
	org.olat.resource.accesscontrol.provider.auto.manager.AutoAccessManagerImplTest.class,
	org.olat.resource.accesscontrol.provider.auto.manager.ExternalIdHandlerTest.class,
	org.olat.resource.accesscontrol.provider.auto.manager.ExternalRefHandlerTest.class,
	org.olat.resource.accesscontrol.provider.auto.manager.IdentifierHandlerTest.class,
	org.olat.resource.accesscontrol.provider.auto.manager.InputValidatorTest.class,
	org.olat.resource.accesscontrol.provider.auto.manager.InternalIdHandlerTest.class,
	org.olat.resource.accesscontrol.provider.auto.manager.SemicolonSplitterTest.class,
	org.olat.shibboleth.manager.DifferenceCheckerTest.class,
	org.olat.shibboleth.manager.ShibbolethAttributesTest.class,
	org.olat.shibboleth.manager.ShibbolethManagerImplTest.class,
	org.olat.shibboleth.handler.DoNothingHandlerTest.class,
	org.olat.shibboleth.handler.FirstValueHandlerTest.class,
	org.olat.shibboleth.handler.SchacGenderHandlerTest.class,
	org.olat.user.UserManagerImplTest.class,
	org.olat.user.propertyhandlers.DatePropertyHandlerTest.class,
	org.olat.user.propertyhandlers.LinkedinPropertyHandlerTest.class,
	org.olat.core.gui.components.form.flexible.impl.elements.FileElementRendererTest.class,
	/**
	 *
	 * Place tests which load their own Spring context
	 * with @ContextConfiguration below the others as they may taint the
	 * cached Spring context
	 *
	 * IMPORTANT: If you create mock spring contexts in the test source tree of olatcore and
	 * you like to use them in olat3 you have to copy them to the test source tree of olat3
	 * as well as the tests on hudson run agains a jar version of olatcore where the test source
	 * tree is not available
	 */
	org.olat.core.commons.services.scheduler.SchedulerTest.class,
	org.olat.upgrade.UpgradeDefinitionTest.class,
	org.olat.upgrade.UpgradeManagerTest.class
})
public class AllTestsJunit4 {
	//
}
