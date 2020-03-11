package com.user.app.interceptor;

import com.user.app.model.TestUser;

public class UserContext {
	
	private static ThreadLocal<TestUser> userHolder = new ThreadLocal<TestUser>();

	public static void setTestUser(TestUser user) {
		userHolder.set(user);
	}

	public static TestUser getTestUser() {
		return userHolder.get();
	}
}
