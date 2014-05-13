package com.stepupit.reminder.applayer.service;

import javax.transaction.NotSupportedException;


/**
 * @author ank
 *
 */
public interface AppService {

	public boolean isModelValid(Object onj) throws NotSupportedException;

}
