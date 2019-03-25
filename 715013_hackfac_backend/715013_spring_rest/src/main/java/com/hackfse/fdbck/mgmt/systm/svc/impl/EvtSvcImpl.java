package com.hackfse.fdbck.mgmt.systm.svc.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackfse.fdbck.mgmt.systm.MailConfig;
import com.hackfse.fdbck.mgmt.systm.XL.XlWriter.ExcelWriter;
import com.hackfse.fdbck.mgmt.systm.XL.XlWriter.ReportXlWritter;
import com.hackfse.fdbck.mgmt.systm.XL.model.ReportFormat;
import com.hackfse.fdbck.mgmt.systm.dao.OutReachEventInfoDao;
import com.hackfse.fdbck.mgmt.systm.dao.OutReachEventPmoDao;
import com.hackfse.fdbck.mgmt.systm.dao.OutReachEventRoleDao;
import com.hackfse.fdbck.mgmt.systm.dao.OutReachEventSummaryDao;
import com.hackfse.fdbck.mgmt.systm.dao.OutReachNotRegisteredDao;
import com.hackfse.fdbck.mgmt.systm.dao.OutReachRegisteredDao;
import com.hackfse.fdbck.mgmt.systm.dao.OutReachStatusDao;
import com.hackfse.fdbck.mgmt.systm.model.OutReachEventInfoDTO;
import com.hackfse.fdbck.mgmt.systm.model.OutReachEventPmoDTO;
import com.hackfse.fdbck.mgmt.systm.model.OutReachEventRoleDTO;
import com.hackfse.fdbck.mgmt.systm.model.OutReachEventSummeryDTO;
import com.hackfse.fdbck.mgmt.systm.model.OutReachNotRegisteredDTO;
import com.hackfse.fdbck.mgmt.systm.model.OutReachRegisteredDTO;
import com.hackfse.fdbck.mgmt.systm.model.OutReachStatusDTO;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachAllEvtRprtRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachEventInfoRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachEventPmoRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachEventRoleRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachEventSummeryRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachNotRegisteredRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachRegisteredRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachStatusRspVo;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachXlRspVo;

@Service
public class EvtSvcImpl {

	@Autowired
	private OutReachRegisteredDao outReachRegisteredDao;

	@Autowired
	private OutReachNotRegisteredDao outReachNotRegisteredDao;

	@Autowired
	private OutReachEventInfoDao outReachEventInfoDao;

	@Autowired
	private OutReachEventSummaryDao outReachEventSummaryDao;

	@Autowired
	private OutReachStatusDao outReachStatusDao;

	@Autowired
	private OutReachEventPmoDao outReachEventPmoDao;

	@Autowired
	private OutReachEventRoleDao outReachEventRoleDao;

	@Autowired
	private ExcelWriter excelWriter;

	public OutReachEventSummeryRspVo findEvntSummry(final String eventId) {
		final Optional<OutReachEventSummeryDTO> outReachEventSummeryDTO = outReachEventSummaryDao.findById(eventId);
		final OutReachEventSummeryRspVo eventSummeryRspVo = new OutReachEventSummeryRspVo();
		if (outReachEventSummeryDTO.isPresent())
			BeanUtils.copyProperties(outReachEventSummeryDTO.get(), eventSummeryRspVo);
		return eventSummeryRspVo;
	}

	public List<OutReachEventSummeryRspVo> findAllEvtSummry() {
		final List<OutReachEventSummeryDTO> eventSummeryDTOs = outReachEventSummaryDao.findAll();
		final List<OutReachEventSummeryRspVo> eventSummeryRspVos = new ArrayList<>();
		eventSummeryDTOs.stream().forEach(evnt -> {
			final OutReachEventSummeryRspVo eventInfoRspVo = new OutReachEventSummeryRspVo();
			BeanUtils.copyProperties(evnt, eventInfoRspVo);
			eventSummeryRspVos.add(eventInfoRspVo);
		});
		return eventSummeryRspVos;
	}

	public List<OutReachEventInfoRspVo> findAllEmpInAnEvt() {
		final List<OutReachEventInfoDTO> eventInfoDTO = outReachEventInfoDao.findAll();
		final List<OutReachEventInfoRspVo> eventInfoRspVos = new ArrayList<>();
		eventInfoDTO.stream().forEach(evnt -> {
			final OutReachEventInfoRspVo eventInfoRspVo = new OutReachEventInfoRspVo();
			BeanUtils.copyProperties(evnt, eventInfoRspVo);
			eventInfoRspVos.add(eventInfoRspVo);
		});
		return eventInfoRspVos;
	}

	public List<OutReachNotRegisteredRspVo> findAllUnrgstrd() {
		final List<OutReachNotRegisteredDTO> eventInfoDTO = outReachNotRegisteredDao.findAll();
		final List<OutReachNotRegisteredRspVo> eventInfoRspVos = new ArrayList<>();
		eventInfoDTO.stream().forEach(evnt -> {
			final OutReachNotRegisteredRspVo eventInfoRspVo = new OutReachNotRegisteredRspVo();
			BeanUtils.copyProperties(evnt, eventInfoRspVo);
			eventInfoRspVos.add(eventInfoRspVo);
		});
		return eventInfoRspVos;
	}

	public List<OutReachRegisteredRspVo> findAllUnattnd() {
		final List<OutReachRegisteredDTO> eventInfoDTO = outReachRegisteredDao.findAll();
		final List<OutReachRegisteredRspVo> eventInfoRspVos = new ArrayList<>();
		eventInfoDTO.stream().forEach(evnt -> {
			final OutReachRegisteredRspVo eventInfoRspVo = new OutReachRegisteredRspVo();
			if (outReachStatusDao.findById(evnt.getEmpId()).isPresent()) {
				BeanUtils.copyProperties(evnt, eventInfoRspVo);
				eventInfoRspVos.add(eventInfoRspVo);
			}
		});
		return eventInfoRspVos;
	}

	public void addFedback(String eventId, String empId, String rating, String description) {
		OutReachStatusDTO outReachStatusDTO = new OutReachStatusDTO(eventId, empId, rating, description);
		outReachStatusDao.save(outReachStatusDTO);
	}

	public void deleteFeedBack(String eventId, String empId, String rating, String description) {
		OutReachStatusDTO outReachStatusDTO = new OutReachStatusDTO(eventId, empId, rating, description);
		outReachStatusDao.delete(outReachStatusDTO);
	}

	public List<OutReachStatusRspVo> getFedbacks() {
		final List<OutReachStatusDTO> fedbackDTO = outReachStatusDao.findAll();
		final List<OutReachStatusRspVo> fedbackRspVos = new ArrayList<>();
		fedbackDTO.stream().forEach(evnt -> {
			final OutReachStatusRspVo eventInfoRspVo = new OutReachStatusRspVo();
			BeanUtils.copyProperties(evnt, eventInfoRspVo);
			fedbackRspVos.add(eventInfoRspVo);
		});
		return fedbackRspVos;
	}

	public List<OutReachEventPmoRspVo> getEventPmos() {
		final List<OutReachEventPmoDTO> eventPmoDTO = outReachEventPmoDao.findAll();
		final List<OutReachEventPmoRspVo> eventPmoRspVos = new ArrayList<>();
		eventPmoDTO.stream().forEach(evnt -> {
			final OutReachEventPmoRspVo outReachEventPmoRspVo = new OutReachEventPmoRspVo();
			BeanUtils.copyProperties(evnt, outReachEventPmoRspVo);
			eventPmoRspVos.add(outReachEventPmoRspVo);
		});
		return eventPmoRspVos;
	}

	public OutReachEventPmoRspVo findEventPmo(String empId) {
		String indEmp = empId;
		if (empId.contains(".")) {
			try {
				indEmp = empId.split(".")[0];
			} catch (Exception e) {
				indEmp = empId;
			}
		}
		Optional<OutReachEventPmoDTO> outReachEventPmoDTO = outReachEventPmoDao.findById(empId);
		final OutReachEventPmoRspVo outReachEventPmoRspVo = new OutReachEventPmoRspVo();
		if (outReachEventPmoDTO.isPresent()) {
			BeanUtils.copyProperties(outReachEventPmoDTO.get(), outReachEventPmoRspVo);
		} else {
			outReachEventPmoDTO = outReachEventPmoDao.findById(empId + ".0");
			if (outReachEventPmoDTO.isPresent()) {
				BeanUtils.copyProperties(outReachEventPmoDTO.get(), outReachEventPmoRspVo);
			}
		}
		return outReachEventPmoRspVo;
	}

	public OutReachEventRoleRspVo addRole(String empId, String roleCode) {
		OutReachEventRoleRspVo outReachEventRoleRspVo = new OutReachEventRoleRspVo();
		OutReachEventRoleDTO outReachEventRoleDTO = new OutReachEventRoleDTO(empId, roleCode);
		BeanUtils.copyProperties(outReachEventRoleDTO, outReachEventRoleRspVo);
		outReachEventRoleDao.save(outReachEventRoleDTO);
		return outReachEventRoleRspVo;
	}

	public OutReachEventRoleRspVo getRole(String empId) {
		final Optional<OutReachEventRoleDTO> outReachEventRoleDTO = outReachEventRoleDao.findById(empId);
		final OutReachEventRoleRspVo outReachEventRoleRspVo = new OutReachEventRoleRspVo();
		if (outReachEventRoleDTO.isPresent())
			BeanUtils.copyProperties(outReachEventRoleDTO.get(), outReachEventRoleRspVo);
		return outReachEventRoleRspVo;
	}

	public List<OutReachEventRoleRspVo> getAllRole() {
		final List<OutReachEventRoleDTO> eventRoleDTO = outReachEventRoleDao.findAll();
		final List<OutReachEventRoleRspVo> eventRoleRspVos = new ArrayList<>();
		eventRoleDTO.stream().forEach(evnt -> {
			final OutReachEventRoleRspVo outReachEventPmoRspVo = new OutReachEventRoleRspVo();
			BeanUtils.copyProperties(evnt, outReachEventPmoRspVo);
			eventRoleRspVos.add(outReachEventPmoRspVo);
		});
		return eventRoleRspVos;
	}

	public OutReachEventRoleRspVo updatRole(String empId, String roleCode) {
		OutReachEventRoleRspVo outReachEventRoleRspVo = new OutReachEventRoleRspVo();
		OutReachEventRoleDTO outReachEventRoleDTO = new OutReachEventRoleDTO(empId, roleCode);
		BeanUtils.copyProperties(outReachEventRoleDTO, outReachEventRoleRspVo);
		outReachEventRoleDao.save(outReachEventRoleDTO);
		return outReachEventRoleRspVo;
	}

	public void deleteRole(String empId) {
		OutReachEventRoleDTO outReachEventRoleDTO = new OutReachEventRoleDTO(empId, "");
		outReachEventRoleDao.delete(outReachEventRoleDTO);
	}

	public void sendEmail(String empId, String status) {
		MailConfig mailConfig = new MailConfig();
		mailConfig.sendMail(empId, status);
	}

	public List<OutReachRegisteredRspVo> findAllNotSendedResponse() {
		final List<OutReachRegisteredDTO> eventInfoDTO = outReachRegisteredDao.findAll();
		final List<OutReachRegisteredRspVo> eventInfoRspVos = new ArrayList<>();
		eventInfoDTO.stream().forEach(evnt -> {
			final OutReachRegisteredRspVo eventInfoRspVo = new OutReachRegisteredRspVo();
			if (!outReachStatusDao.findById(evnt.getEmpId()).isPresent()) {
				BeanUtils.copyProperties(evnt, eventInfoRspVo);
				eventInfoRspVos.add(eventInfoRspVo);
			}
		});
		return eventInfoRspVos;
	}

	public OutReachXlRspVo getXL(String path) throws IOException {
		OutReachXlRspVo outReachXlRspVo = new OutReachXlRspVo(excelWriter.createXlSheet(path));
		return outReachXlRspVo;
	}

	public OutReachXlRspVo findAllEvtRprt(String path, String associateEmpId) throws IOException {
		final List<OutReachEventSummeryDTO> eventSummeryDTOs = outReachEventSummaryDao.findAll();
		final List<OutReachEventInfoDTO> eventInfoDTO = outReachEventInfoDao.findAll();
		final List<ReportFormat> reportFormats = new ArrayList<>();
		for (OutReachEventSummeryDTO evnt : eventSummeryDTOs) {
			final String eventId = evnt.getEventId();
			for (OutReachEventInfoDTO evInfoDTO : eventInfoDTO) {
				if (!StringUtils.isBlank(associateEmpId)) {
					if ((associateEmpId + ".0").equals(evInfoDTO.getEmpId())) {
						ReportFormat reportFormat = new ReportFormat();
						reportFormat.setEventId(eventId);
						reportFormat.setEmpId(associateEmpId);
						reportFormat.setBaseLocation(evInfoDTO.getBaseLocation());
						reportFormat.setProject(evnt.getProject());
						reportFormats.add(reportFormat);
					} else if (associateEmpId.equals("undefined")) {
						ReportFormat reportFormat = new ReportFormat();
						reportFormat.setEventId(eventId);
						reportFormat.setEmpId(evInfoDTO.getEmpId());
						reportFormat.setBaseLocation(evInfoDTO.getBaseLocation());
						reportFormat.setProject(evnt.getProject());
						reportFormats.add(reportFormat);

					}
				} else {
					ReportFormat reportFormat = new ReportFormat();
					reportFormat.setEventId(eventId);
					reportFormat.setEmpId(evInfoDTO.getEmpId());
					reportFormat.setBaseLocation(evInfoDTO.getBaseLocation());
					reportFormat.setProject(evnt.getProject());
					reportFormats.add(reportFormat);

				}
			}

		}
		OutReachXlRspVo outReachXlRspVo = new OutReachXlRspVo();
		ReportXlWritter reportXlWritter = new ReportXlWritter();
		outReachXlRspVo.setPath(reportXlWritter.createXlSheet(path, reportFormats, "PMO_AND_ADMIN"));
		return outReachXlRspVo;
	}

	public OutReachXlRspVo indEvtRprt(String empid, String path, String associateEmpId) throws IOException {
		final List<OutReachEventInfoDTO> eventInfoDTO = outReachEventInfoDao.findAll();
		final List<ReportFormat> reportFormats = new ArrayList<>();
		final String eventId = findEventPmo(empid).getEventId();
		final Optional<OutReachEventSummeryDTO> eventSummeryDTO = outReachEventSummaryDao.findById(eventId);
		for (OutReachEventInfoDTO evInfoDTO : eventInfoDTO) {

			if (!StringUtils.isBlank(associateEmpId)) {
				if ((associateEmpId + ".0").equals(evInfoDTO.getEmpId())) {
					ReportFormat reportFormat = new ReportFormat();
					reportFormat.setEventId(eventId);
					reportFormat.setEmpId(associateEmpId);
					reportFormat.setBaseLocation(evInfoDTO.getBaseLocation());
					reportFormat.setProject(eventSummeryDTO.get().getProject());
					reportFormats.add(reportFormat);
				} else if (associateEmpId.equals("undefined")) {
					ReportFormat reportFormat = new ReportFormat();
					reportFormat.setEventId(eventId);
					reportFormat.setEmpId(evInfoDTO.getEmpId());
					reportFormat.setBaseLocation(evInfoDTO.getBaseLocation());
					reportFormat.setProject(eventSummeryDTO.get().getProject());
					reportFormats.add(reportFormat);

				}
			} else {
				ReportFormat reportFormat = new ReportFormat();
				reportFormat.setEventId(eventId);
				reportFormat.setEmpId(evInfoDTO.getEmpId());
				reportFormat.setBaseLocation(evInfoDTO.getBaseLocation());
				reportFormat.setProject(eventSummeryDTO.get().getProject());
				reportFormats.add(reportFormat);

			}

		}

		OutReachXlRspVo outReachXlRspVo = new OutReachXlRspVo();
		ReportXlWritter reportXlWritter = new ReportXlWritter();
		outReachXlRspVo.setPath(reportXlWritter.createXlSheet(path, reportFormats, "POC"));
		return outReachXlRspVo;
	}
}