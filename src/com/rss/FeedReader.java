package com.rss;

import java.util.ArrayList;
import java.util.List;

public class FeedReader {

	List<Feed> feeds = new ArrayList<>();

	public FeedReader(List<String> urls) {
		for (String url : urls) {
			feeds.add(new Feed(url));
		}
	}

	@Override
	public String toString() {
		String result = "";
		for (Feed feed : feeds) {
			result += feed.toString() + "\n";
		}
		return result;
	}
}