package com.nandbox.bots.api.inmessages;

import com.nandbox.bots.api.util.Utils;
import com.nandbox.bots.api.data.Chat;
import com.nandbox.bots.api.data.User;

import net.minidev.json.JSONObject;

/**
 * Object represents a chat member user returned in getChatMember banChatMember,
 * unbanChatMember, removeChatMember and when user join or leaves the chat.
 * 
 * @author Hossam Mohamed
 *
 */
public class ChatMember {

	private static final String KEY_CHAT_MEMBER = "chatMember";
	private static final String KEY_USER = "user";
	private static final String KEY_CHAT = "chat";
	private static final String KEY_TYPE = "type";
	private static final String KEY_MEMBER_SINCE = "member_since";
	private static final String KEY_STATUS = "status";

	private User user;
	private Chat chat;
	private String type;
	private Long memberSince;
	private String status;

	public ChatMember(JSONObject jsonObj) {

		JSONObject obj = (JSONObject) jsonObj.get(KEY_CHAT_MEMBER);
		this.user = obj.get(KEY_USER) == null ? null : new User((JSONObject) obj.get(KEY_USER));
		this.chat = obj.get(KEY_CHAT) == null ? null : new Chat((JSONObject) obj.get(KEY_CHAT));

		this.type = (String) obj.get(KEY_TYPE);
		this.memberSince = Utils.getLong(obj.get(KEY_MEMBER_SINCE));
		this.status = (String) obj.get(KEY_STATUS);

	}

	public JSONObject toJsonObject() {

		JSONObject obj = new JSONObject();

		if (user != null) {
			obj.put(KEY_USER, user.toJsonObject());
		}
		if (chat != null) {
			obj.put(KEY_CHAT, chat.toJsonObject());
		}
		if (type != null) {
			obj.put(KEY_TYPE, type);
		}
		if (memberSince != null) {
			obj.put(KEY_MEMBER_SINCE, memberSince);
		}
		if (status != null) {
			obj.put(KEY_STATUS, status);
		}

		return obj;

	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the memberSince
	 */
	public Long getMemberSince() {
		return memberSince;
	}

	/**
	 * @param memberSince
	 *            the memberSince to set
	 */
	public void setMemberSince(Long memberSince) {
		this.memberSince = memberSince;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the chat
	 */
	public Chat getChat() {
		return chat;
	}

	/**
	 * @param chat
	 *            the chat to set
	 */
	public void setChat(Chat chat) {
		this.chat = chat;
	}

}