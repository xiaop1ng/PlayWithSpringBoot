package com.xiaoping.pojo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Rs {

	private static Logger logger = LoggerFactory.getLogger(Rs.class);
	// 定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();

	// 响应业务错误码
	private Integer err;

	// 响应消息
	private String msg;

	// 响应中的数据
	private Object data;

	public final static int ERROR_CODE_OK = 0;

	public final static int ERROR_CODE_BAD_REQUEST = 400;

	public final static int ERROR_CODE_UNAUTHORIZED = 401;

	public final static int ERROR_CODE_FORBIDDEN = 403;

	public final static int ERROR_CODE_NOT_FOUND = 404;

	public final static int ERROR_CODE_SERVER_ERROR = 500;

	public final static String MSG_SUCCESS = "success";

	public final static String MSG_ERROR = "error";

	public final static String MSG_FAIL = "fail";


	public static Rs build(Integer err, String msg, Object data) {
		return new Rs(err, msg, data);
	}

	public static Rs ok(Object data) {
		return new Rs(data);
	}

	public static Rs ok(Object data, String msg) {
		return new Rs(ERROR_CODE_OK, msg, data);
	}

	public static Rs ok() {
		return new Rs(null);
	}
	
	public static Rs err(Integer err, String msg) {
		return new Rs(err, msg, null);
	}

	public static Rs errParamer(String msg) {
		return new Rs(ERROR_CODE_BAD_REQUEST, msg, null);
	}

	public static Rs errMsg(String msg) {
		return new Rs(ERROR_CODE_SERVER_ERROR, msg, null);
	}

	public static Rs errMap(Object data) {
		return new Rs(ERROR_CODE_SERVER_ERROR, MSG_ERROR, data);
	}

	public static Rs errTokenMsg(String msg) {
		return new Rs(ERROR_CODE_UNAUTHORIZED, msg, null);
	}

	public static Rs errException(Exception e) {
		logger.error(e.getMessage(), e);
		return new Rs(ERROR_CODE_SERVER_ERROR, e.getMessage(), null);
	}

	private Rs() {

	}

	private Rs(Integer err, String msg, Object data) {
		this.err = err;
		this.msg = msg;
		this.data = data;
	}

	private Rs(Object data) {
		this.err = ERROR_CODE_OK;
		this.msg = MSG_SUCCESS;
		this.data = data;
	}

	public Boolean isOK() {
		return ERROR_CODE_OK == this.err;
	}

	public Integer getErr() {
		return err;
	}

	public void setErr(Integer err) {
		this.err = err;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 将json结果集转化为LeeJSONResult对象 需要转换的对象是一个类
	 */
	public static Rs formatToPojo(String jsonData, Class<?> clazz) {
		try {
			if (clazz == null) {
				return MAPPER.readValue(jsonData, Rs.class);
			}
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (clazz != null) {
				if (data.isObject()) {
					obj = MAPPER.readValue(data.traverse(), clazz);
				} else if (data.isTextual()) {
					obj = MAPPER.readValue(data.asText(), clazz);
				}
			}
			return build(jsonNode.get("err").intValue(), jsonNode.get("msg").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * @Description: 没有object对象的转化
	 * @param json
	 * @return
	 */
	public static Rs format(String json) {
		try {
			return MAPPER.readValue(json, Rs.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Object是集合转化 需要转换的对象是一个list
	 */
	public static Rs formatToList(String jsonData, Class<?> clazz) {
		try {
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (data.isArray() && data.size() > 0) {
				obj = MAPPER.readValue(data.traverse(),
						MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
			}
			return build(jsonNode.get("err").intValue(), jsonNode.get("msg").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

}
