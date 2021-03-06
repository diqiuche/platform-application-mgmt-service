package com.ai.paas.cpaas.be.am.service.remote;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.ai.paas.cpaas.be.am.manage.model.GeneralHttpResp;
import com.ai.paas.cpaas.be.am.manage.model.chronos.JobsResp;
import com.ai.paas.cpaas.be.am.manage.model.consul.ServiceInfo;
import com.ai.paas.cpaas.be.am.service.IRemoteService;
import com.ai.paas.cpaas.be.am.service.RemoteServiceException;

public class AgentRemoteService implements IRemoteService {
	private static final String HTTP = "http://";
	private static final String REQ_PATH = "/agent-web-api/simpCommand/exec";
	private String address;

	public AgentRemoteService(String address) {
		this.address = address;
	}

	@Override
	public <T extends GeneralHttpResp> T deployLongRun(String createAppReq, Class<T> cls) throws RemoteServiceException {
		T t = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(HTTP + address + REQ_PATH);
			CloseableHttpResponse resp = httpclient.execute(httpPost);
		} catch (ClientProtocolException e) {
			throw new RemoteServiceException(e);
		} catch (IOException e) {
			throw new RemoteServiceException(e);
		}
		return t;
	}

	@Override
	public <T extends GeneralHttpResp> T getContainerInfo(String containerId, Class<T> cls) throws RemoteServiceException {
		return null;
	}

	@Override
	public <T extends GeneralHttpResp> T putConfig(String changeConfigReq, String containerId, Class<T> cls) throws RemoteServiceException {
		return null;
	}

	private static class AgentReq {
		private String aid;
		private String command;

		public String getAid() {
			return aid;
		}

		public void setAid(String aid) {
			this.aid = aid;
		}

		public String getCommand() {
			return command;
		}

		public void setCommand(String command) {
			this.command = command;
		}

	}

	private static class AgentResp {
		public static final String SUCCESS = "0";
		public static final String FAILED = "1";
		private String code;
		private String msg;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

	}

	@Override
	public <T extends GeneralHttpResp> T destroyLongRun(String containerId, Class<T> cls) throws RemoteServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends GeneralHttpResp> T getConfig(String containerId, String version, Class<T> cls) throws RemoteServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registerService(String param) throws RemoteServiceException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deRegisterService(String param) throws RemoteServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ServiceInfo> getServiceInfo(String param) throws RemoteServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralHttpResp deployTimer(String createAppReq) throws RemoteServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralHttpResp deployTimerDependency(String createAppReq) throws RemoteServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralHttpResp destroyTimer(String name) throws RemoteServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralHttpResp forceTimer(String name) throws RemoteServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobsResp getTimerJobs() throws RemoteServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean timerJobExist(String name) throws RemoteServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
