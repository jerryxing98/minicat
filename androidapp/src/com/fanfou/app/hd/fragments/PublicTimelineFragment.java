package com.fanfou.app.hd.fragments;

import android.os.Bundle;
import android.util.Log;

import com.fanfou.app.hd.App;
import com.fanfou.app.hd.dao.model.StatusModel;
import com.fanfou.app.hd.service.FanFouService;

/**
 * @author mcxiaoke
 * @version 1.0 2012.02.06
 * @version 1.1 2012.02.24
 * @version 1.2 2012.03.08
 * 
 */
public class PublicTimelineFragment extends BaseTimlineFragment {
	private static final String TAG = PublicTimelineFragment.class
			.getSimpleName();

	public static PublicTimelineFragment newInstance() {
		return newInstance(false);
	}

	public static PublicTimelineFragment newInstance(boolean refresh) {
		Bundle args = new Bundle();
		args.putBoolean("refresh", refresh);
		PublicTimelineFragment fragment = new PublicTimelineFragment();
		fragment.setArguments(args);
		if (App.DEBUG) {
			Log.d(TAG, "newInstance() " + fragment);
		}
		return fragment;
	}

	@Override
	protected int getType() {
		return StatusModel.TYPE_PUBLIC;
	}

	@Override
	protected void doFetch(boolean doGetMore) {
		if (App.DEBUG) {
			Log.d(TAG, "doFetch() doGetMore=" + doGetMore);
		}
		final ResultHandler handler = new ResultHandler(this);
		FanFouService.getPublicTimeline(getActivity(), handler);
	}

}
