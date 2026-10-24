package com.rss;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class Feed {
	private String url;
	private String title = "";
	private List<FeedItem> items = new ArrayList<FeedItem>();

	public Feed(String url) {
		this.url = url;
		try {
			URL feedUrl = URI.create(url).toURL();
			InputStream stream = feedUrl.openStream();
			SyndFeed feed = new SyndFeedInput().build(new XmlReader(stream));
			stream.close();
			this.title = feed.getTitle();
			for (SyndEntry entry : feed.getEntries()) {
				String description = "";
				if (entry.getDescription() != null) {
					description = entry.getDescription().getValue();
				}
				FeedItem item = new FeedItem(entry.getTitle(), entry.getLink(),
						description, entry.getPublishedDate());
				this.items.add(item);

			}

		} catch (Exception e) {
			System.err.println("Could not read feed " + url + ": " + e.getMessage());
		}
	}

	public String getTitle() {
		return title;
	}

	public List<FeedItem> getItems() {
		return items;
	}

	@Override
	public String toString() {

		String feeds = "============= " + title + " =============\n";

		for (FeedItem item : items) {
			feeds += item.toString() + "\n";
			feeds += "--------------------------------------------------\n";
		}

		return feeds;

	}
}
