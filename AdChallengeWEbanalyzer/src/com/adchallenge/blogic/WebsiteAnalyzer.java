package com.adchallenge.blogic;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.adchallenge.model.Website;

public class WebsiteAnalyzer {

	public WebsiteAnalyzer() {
	}

	public static void main(String args[]) {
		WebsiteAnalyzer websiteAnalyzer = new WebsiteAnalyzer();
		websiteAnalyzer.reportPageAccess("www.google.com");
		websiteAnalyzer.reportPageAccess("www.google.com");
		websiteAnalyzer.reportPageAccess("www.googlewe.com");
		websiteAnalyzer.reportPageAccess("www.googleae.com");
		websiteAnalyzer.reportPageAccess("www.google.com");
		websiteAnalyzer.reportPageAccess("www.googlea.com");
		websiteAnalyzer.reportPageAccess("www.googleae.com");
		websiteAnalyzer.reportPageAccess("www.googleae.com");
		List<String> topNPages = websiteAnalyzer.getTopNPages(3);
		for (String string : topNPages) {
			System.out.println(string);
		}
	}

	/**
	 * this map is responsible for maintaining the count and the List of
	 * websites. E.g. 1 -> [website1, website2] Here count is the number of the
	 * times, the website id hit.
	 */
	Map<Integer, Set<Website>> allWebsiteCountMap = new HashMap<Integer, Set<Website>>();

	/**
	 * This map will contains, the name of the website with the Object of the
	 * website. It will be easy to fetch the website object from the list of
	 * website.
	 */
	Map<String, Website> urlWEbbsiteMapping = new HashMap<String, Website>();

	// you may declare and use other variables or
	// other helper methods you may need
	public void reportPageAccess(String pageUrl) {
		// your pre here

		if (urlWEbbsiteMapping.containsKey(pageUrl)) {
			// Get the website object if exist
			Website website = urlWEbbsiteMapping.get(pageUrl);
			// remove it from Map
			Set<Website> allWebsite = allWebsiteCountMap
					.get(website.getCount());
			allWebsite.remove(website);
			// If the map is zero then remove the key valus from the
			// allWebsiteCount Map also.
			if (allWebsite.size() == 0) {
				allWebsiteCountMap.remove(website.getCount());
			}

			website.setCount(website.getCount() + 1);
			website.setLastClickedTime(new Date());
			// get counter and add it with new counter to new index.
			if (allWebsiteCountMap.containsKey(website.getCount())) {
				Set<Website> setForSpecificCount = allWebsiteCountMap
						.get(website.getCount());
				setForSpecificCount.add(website);
			} else {
				HashSet<Website> hashSet = new HashSet<Website>();
				hashSet.add(website);
				allWebsiteCountMap.put(website.getCount(), hashSet);
			}

		} else {
			Website website = new Website();
			website.setCount(0);
			website.setLastClickedTime(new Date());
			website.setWebsiteUrl(pageUrl);

			if (allWebsiteCountMap.containsKey(website.getCount())) {
				Set<Website> set = allWebsiteCountMap.get(website.getCount());
				set.add(website);
			} else {
				// Put new Website on Map with counter
				HashSet<Website> hashSet = new HashSet<Website>();
				hashSet.add(website);
				allWebsiteCountMap.put(website.getCount(), hashSet);
			}
			// Put new website MappingMap, to find object fast, next time.
			urlWEbbsiteMapping.put(pageUrl, website);
		}
	}

	// the size of the list returned must be n
	public List getTopNPages(int n) {
		List<String> allWebsiteNames = new LinkedList<String>();

		Set<Integer> keySet = allWebsiteCountMap.keySet();
		TreeSet<Integer> sortedKey = new TreeSet<Integer>(new CompareTheKeys());
		sortedKey.addAll(keySet);

		for (Integer integer : sortedKey) {
			Set<Website> set = allWebsiteCountMap.get(integer);
			for (Iterator<Website> iterator = set.iterator(); iterator
					.hasNext();) {
				Website website = (Website) iterator.next();
				// Keep adding the data till the List of the website is less
				// than the number of required list.
				if (allWebsiteNames.size() < n) {
					allWebsiteNames.add(website.getWebsiteUrl());
				} else {
					break;

				}
			}
		}
		return allWebsiteNames;
		// your pre here
	}

	/**
	 * This method will clean both the map.
	 */
	public void clean() {
		allWebsiteCountMap.clear();
		urlWEbbsiteMapping.clear();

	}
}

/**
 * This class is responsible for arranging the key vald of the map to reverse
 * order. As we need the website with the hightest hit first.
 * 
 * @author hvanparx
 * 
 */
class CompareTheKeys implements Comparator<Integer> {

	public int compare(Integer arg0, Integer arg1) {
		int firstInt = (Integer) arg0;
		int secondInt = (Integer) arg1;
		return secondInt - firstInt;
	}

}