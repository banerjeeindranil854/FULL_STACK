package com.hackfac.reposortory;

import java.net.MalformedURLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.excel.poi.PoiItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;

import com.hackfac.listener.JobCompletionNotificationListener;
import com.hackfac.model.OutReachEventInfoDTO;
import com.hackfac.model.OutReachEventPmoDTO;
import com.hackfac.model.OutReachEventSummeryDTO;
import com.hackfac.model.OutReachNotRegisteredDTO;
import com.hackfac.model.OutReachRegisteredDTO;
import com.hackfac.processoe.OutReachEventInfoProcessor;
import com.hackfac.processoe.OutReachEventPmoProcessor;
import com.hackfac.processoe.OutReachEventSummeryProcessor;
import com.hackfac.processoe.OutReachNotRegisteredProcessor;
import com.hackfac.processoe.OutReachRegisteredProcessor;
import com.hackfac.rowmapper.EventInfoRowmapper;
import com.hackfac.rowmapper.EventPmoRowMapper;
import com.hackfac.rowmapper.EventSummeryRowmapper;
import com.hackfac.rowmapper.NonRegisterUserRowmapper;
import com.hackfac.rowmapper.RegisterUserRowmapper;

@EnableBatchProcessing
@Configuration
public class XlFileToDatabaseConfig {

	@Value("${outreach.register}")
	private String register;

	@Value("${outreach.notregister}")
	private String notregister;

	@Value("${outreach.eventsummery}")
	private String eventsummery;
	
	@Value("${outreach.eventinfo}")
	private String eventinfo;
	
	@Value("${outreach.eventpmo}")
	private String eventpmo;

	private String FILE="file:";

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;

	// begin reader, writer, and processor

	@Bean
	public ItemReader<OutReachNotRegisteredDTO> xlOutReachNotRegisterReader() throws MalformedURLException {
		PoiItemReader<OutReachNotRegisteredDTO> reader = new PoiItemReader<>();

		reader.setLinesToSkip(1);
		reader.setResource(new UrlResource(FILE + notregister));
		reader.setRowMapper(new NonRegisterUserRowmapper());
		return reader;
	}

	@Bean
	public ItemReader<OutReachRegisteredDTO> xlOutReachRegisterReader() throws MalformedURLException {
		PoiItemReader<OutReachRegisteredDTO> reader = new PoiItemReader<>();

		reader.setLinesToSkip(1);
		reader.setResource(new UrlResource(FILE + register));
		reader.setRowMapper(new RegisterUserRowmapper());
		return reader;
	}

	@Bean
	public ItemReader<OutReachEventSummeryDTO> xlOutReachEventSummeryReader() throws MalformedURLException {
		PoiItemReader<OutReachEventSummeryDTO> reader = new PoiItemReader<>();

		reader.setLinesToSkip(1);
		reader.setResource(new UrlResource(FILE + eventsummery));
		reader.setRowMapper(new EventSummeryRowmapper());
		return reader;
	}
	
	@Bean
	public ItemReader<OutReachEventInfoDTO> xlOutReachEventInfoReader() throws MalformedURLException {
		PoiItemReader<OutReachEventInfoDTO> reader = new PoiItemReader<>();

		reader.setLinesToSkip(1);
		reader.setResource(new UrlResource(FILE + eventinfo));
		reader.setRowMapper(new EventInfoRowmapper());
		return reader;
	}
	
	@Bean
	public ItemReader<OutReachEventPmoDTO> xlOutReachEventPmoReader() throws MalformedURLException {
		PoiItemReader<OutReachEventPmoDTO> reader = new PoiItemReader<>();

		reader.setLinesToSkip(1);
		reader.setResource(new UrlResource(FILE + eventpmo));
		reader.setRowMapper(new EventPmoRowMapper());
		return reader;
	}

	@Bean
	ItemProcessor<OutReachNotRegisteredDTO, OutReachNotRegisteredDTO> xlOutReachNotRegisteredProcessor() {
		return new OutReachNotRegisteredProcessor();
	}

	@Bean
	ItemProcessor<OutReachRegisteredDTO, OutReachRegisteredDTO> xlOutReachRegisteredProcessor() {
		return new OutReachRegisteredProcessor();
	}

	@Bean
	ItemProcessor<OutReachEventSummeryDTO, OutReachEventSummeryDTO> xlOutReachEventSummeryProcessor() {
		return new OutReachEventSummeryProcessor();
	}
	
	@Bean
	ItemProcessor<OutReachEventInfoDTO, OutReachEventInfoDTO> xlOutReachEventInfoProcessor() {
		return new OutReachEventInfoProcessor();
	}
	
	@Bean
	ItemProcessor<OutReachEventPmoDTO, OutReachEventPmoDTO> xlOutReachEventPmoProcessor() {
		return new OutReachEventPmoProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<OutReachNotRegisteredDTO> xlOutReachNotRegisteredWriter() {
		JdbcBatchItemWriter<OutReachNotRegisteredDTO> xlOutReachRegisteredWriter = new JdbcBatchItemWriter<OutReachNotRegisteredDTO>();
		xlOutReachRegisteredWriter.setItemSqlParameterSourceProvider(
				new BeanPropertyItemSqlParameterSourceProvider<OutReachNotRegisteredDTO>());
		xlOutReachRegisteredWriter.setSql(
				"INSERT INTO hackfac.outreach_not_registered (event_id, event_name, beneficiary_name, base_location, event_date, emp_id) VALUES (:eventId, :eventName, :beneficiaryName, :baseLocation, :eventDate, :empId)");
		xlOutReachRegisteredWriter.setDataSource(dataSource);
		return xlOutReachRegisteredWriter;
	}

	@Bean
	public JdbcBatchItemWriter<OutReachRegisteredDTO> xlOutReachRegisteredWriter() {
		JdbcBatchItemWriter<OutReachRegisteredDTO> xlOutReachRegisteredWriter = new JdbcBatchItemWriter<OutReachRegisteredDTO>();
		xlOutReachRegisteredWriter.setItemSqlParameterSourceProvider(
				new BeanPropertyItemSqlParameterSourceProvider<OutReachRegisteredDTO>());
		xlOutReachRegisteredWriter.setSql(
				"INSERT INTO hackfac.outreach_registered (event_id, event_name, beneficiary_name, base_location, event_date, emp_id) VALUES (:eventId, :eventName, :beneficiaryName, :baseLocation, :eventDate, :empId)");
		xlOutReachRegisteredWriter.setDataSource(dataSource);
		return xlOutReachRegisteredWriter;
	}

	@Bean
	public JdbcBatchItemWriter<OutReachEventSummeryDTO> xlOutReachEventSummeryWriter() {
		JdbcBatchItemWriter<OutReachEventSummeryDTO> xlOutReachEventSummeryWriter = new JdbcBatchItemWriter<OutReachEventSummeryDTO>();
		xlOutReachEventSummeryWriter.setItemSqlParameterSourceProvider(
				new BeanPropertyItemSqlParameterSourceProvider<OutReachEventSummeryDTO>());
		xlOutReachEventSummeryWriter.setSql(
				"INSERT INTO hackfac.outreach_event_summery (event_id, month, base_location, beneficiary_name, venue_address, council_name, project, category, event_name, event_description, event_date, total_volunteer, total_volunteer_hour, total_travle_houres, overall_volunteer_hours) VALUES (:eventId, :month, :baseLocation, :beneficiaryName, :venueAddress, :councilName, :project, :category, :eventName, :eventDescription, :eventDate, :totalVolunteer, :totalVolunteerHour, :totalTravleHoures, :overallVolunteerHours)");
		xlOutReachEventSummeryWriter.setDataSource(dataSource);
		return xlOutReachEventSummeryWriter;
	}
	
	@Bean
	public JdbcBatchItemWriter<OutReachEventInfoDTO> xlOutReachEventInfoWriter() {
		JdbcBatchItemWriter<OutReachEventInfoDTO> xlOutReachEventInfoWriter = new JdbcBatchItemWriter<OutReachEventInfoDTO>();
		xlOutReachEventInfoWriter.setItemSqlParameterSourceProvider(
				new BeanPropertyItemSqlParameterSourceProvider<OutReachEventInfoDTO>());
		xlOutReachEventInfoWriter.setSql(
				"INSERT INTO hackfac.outreach_event_info (event_id, base_location, beneficiary_name, council_name, event_name, event_description, event_date, emp_id, emp_name, volunteer_hour, travle_houres, lives_impacted, business_unit, status, iiep_category) VALUES (:eventId, :baseLocation, :beneficiaryName, :councilName, :eventName, :eventDescription, :eventDate, :empId, :empName, :volunteerHour, :travleHoures, :livesImpacted, :businessUnit, :status, :iIEPCategory)");
		xlOutReachEventInfoWriter.setDataSource(dataSource);
		return xlOutReachEventInfoWriter;
	}
	
	@Bean
	public JdbcBatchItemWriter<OutReachEventPmoDTO> xlOutReachEventPmoWriter() {
		JdbcBatchItemWriter<OutReachEventPmoDTO> xlOutReachEventInfoWriter = new JdbcBatchItemWriter<OutReachEventPmoDTO>();
		xlOutReachEventInfoWriter.setItemSqlParameterSourceProvider(
				new BeanPropertyItemSqlParameterSourceProvider<OutReachEventPmoDTO>());
		xlOutReachEventInfoWriter.setSql(
				"INSERT INTO hackfac.outreach_event_pmo (event_id, emp_id) VALUES (:eventId, :empId)");
		xlOutReachEventInfoWriter.setDataSource(dataSource);
		return xlOutReachEventInfoWriter;
	}

	// end reader, writer, and processor

	// begin job info
	@Bean
	public Step xlFileToDatabaseStep1() throws MalformedURLException {
		return stepBuilderFactory.get("XlFileToDatabaseStep1")
				.<OutReachNotRegisteredDTO, OutReachNotRegisteredDTO>chunk(10).reader(xlOutReachNotRegisterReader())
				.processor(xlOutReachNotRegisteredProcessor()).writer(xlOutReachNotRegisteredWriter()).build();
	}

	@Bean
	public Step xlFileToDatabaseStep2() throws MalformedURLException {
		return stepBuilderFactory.get("XlFileToDatabaseStep2").<OutReachRegisteredDTO, OutReachRegisteredDTO>chunk(10)
				.reader(xlOutReachRegisterReader()).processor(xlOutReachRegisteredProcessor())
				.writer(xlOutReachRegisteredWriter()).build();
	}

	@Bean
	public Step xlFileToDatabaseStep3() throws MalformedURLException {
		return stepBuilderFactory.get("XlFileToDatabaseStep3")
				.<OutReachEventSummeryDTO, OutReachEventSummeryDTO>chunk(10).reader(xlOutReachEventSummeryReader())
				.processor(xlOutReachEventSummeryProcessor()).writer(xlOutReachEventSummeryWriter()).build();
	}
	
	@Bean
	public Step xlFileToDatabaseStep4() throws MalformedURLException {
		return stepBuilderFactory.get("XlFileToDatabaseStep4")
				.<OutReachEventInfoDTO, OutReachEventInfoDTO>chunk(10).reader(xlOutReachEventInfoReader())
				.processor(xlOutReachEventInfoProcessor()).writer(xlOutReachEventInfoWriter()).build();
	}
	
	@Bean
	public Step xlFileToDatabaseStep5() throws MalformedURLException {
		return stepBuilderFactory.get("XlFileToDatabaseStep5")
				.<OutReachEventPmoDTO, OutReachEventPmoDTO>chunk(10).reader(xlOutReachEventPmoReader())
				.processor(xlOutReachEventPmoProcessor()).writer(xlOutReachEventPmoWriter()).build();
	}

	@Bean
	Job csvFileToDatabaseJob(JobCompletionNotificationListener listener,JobBuilderFactory jobBuilderFactory) throws MalformedURLException {
		return jobBuilderFactory.get("XlFileToDatabaseJob").incrementer(new RunIdIncrementer()).listener(listener)
				.start(xlFileToDatabaseStep1()).next(xlFileToDatabaseStep2()).next(xlFileToDatabaseStep3()).next(xlFileToDatabaseStep4()).next(xlFileToDatabaseStep5()).build();
	}
	// end job info
}
