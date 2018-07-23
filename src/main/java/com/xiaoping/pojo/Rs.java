package com.xiaoping.pojo;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Rs {

	// 定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();

	// 响应业务错误码
	private Integer err;

	// 响应消息
	private String msg;

	// 响应中的数据
	private Object data;


	public static Rs build(Integer err, String msg, Object data) {
		return new Rs(err, msg, data);
	}

	public static Rs ok(Object data) {
		return new Rs(data);
	}

	public static Rs ok() {
		return new Rs(null);
	}
	
	public static Rs err(Integer err, String msg) {
		return new Rs(err, msg, null);
	}

	public static Rs errorMsg(String msg) {
		return new Rs(500, msg, null);
	}

	public static Rs errorMap(Object data) {
		return new Rs(501, "error", data);
	}

	public static Rs errorTokenMsg(String msg) {
		return new Rs(502, msg, null);
	}

	public static Rs errorException(String msg) {
		return new Rs(555, msg, null);
	}

	public Rs() {

	}

	public Rs(Integer err, String msg, Object data) {
		this.err = err;
		this.msg = msg;
		this.data = data;
	}

	public Rs(Object data) {
		this.err = 200;
		this.msg = "OK";
		this.data = data;
	}

	public Boolean isOK() {
		return this.err == 0;
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
