package com.rss;

import java.util.Date;

public class FeedItem {

	private String title;
	private String link;
	private String description;
	private Date pubDate;

	public FeedItem(String title, String link, String description, Date pubDate) {
		this.title = title;
		this.link = link;
		this.description = description;
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return "Title: " + title + "\n"
				+ "Link: " + link + "\n"
				+ "Description: " + description + "\n"
				+ "Publish Date: " + pubDate + "\n";

	}

}
