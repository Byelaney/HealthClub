package com.Club.Service;

import java.util.ArrayList;

import com.Club.Model.Activity;

public interface ActivityServiceInterface {
	public ArrayList<Activity> getUnDueActivity(String account);
	public ArrayList<Activity> getUnDueActivity();
	public boolean addActivity(Activity activity);
}
