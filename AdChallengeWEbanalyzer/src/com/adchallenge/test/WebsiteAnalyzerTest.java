package com.adchallenge.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.adchallenge.blogic.WebsiteAnalyzer;

public class WebsiteAnalyzerTest {
	WebsiteAnalyzer websiteAnalyzer = null;

	@Before
	public void setUp() {
		websiteAnalyzer = new WebsiteAnalyzer();
	}

	@After
	public void finish() {
		websiteAnalyzer.clean();
	}

	@Test
	public void validateize() {
		websiteAnalyzer.reportPageAccess("www.google.com");
		websiteAnalyzer.reportPageAccess("www.google.com");
		websiteAnalyzer.reportPageAccess("www.googlewe.com");
		websiteAnalyzer.reportPageAccess("www.googleae.com");
		websiteAnalyzer.reportPageAccess("www.google.com");
		websiteAnalyzer.reportPageAccess("www.googlea.com");
		websiteAnalyzer.reportPageAccess("www.googleae.com");
		websiteAnalyzer.reportPageAccess("www.googleae.com");
		List topNPages = websiteAnalyzer.getTopNPages(3);
		assertTrue(topNPages.size() == 3);
	}

	@Test
	public void validateizeEmpty() {
		List topNPages = websiteAnalyzer.getTopNPages(3);
		assertTrue(topNPages.size() == 0);
	}

	@Test
	public void validateSizeMaximum() {
		websiteAnalyzer.reportPageAccess("www.google.com");
		websiteAnalyzer.reportPageAccess("www.google.com");
		websiteAnalyzer.reportPageAccess("www.googlewe.com");
		List topNPages = websiteAnalyzer.getTopNPages(3);
		assertTrue(topNPages.size() == 2);
	}

	@Test
	public void validateSizeAllSame() {
		websiteAnalyzer.reportPageAccess("www.google.com");
		websiteAnalyzer.reportPageAccess("www.google.com");
		websiteAnalyzer.reportPageAccess("www.google.com");
		List topNPages = websiteAnalyzer.getTopNPages(3);
		assertTrue(topNPages.size() == 1);
	}

	@Test
	public void validateSizeWithNullUrl() {
		websiteAnalyzer.reportPageAccess(null);
		websiteAnalyzer.reportPageAccess("www.google.com");
		websiteAnalyzer.reportPageAccess("www.google.com");
		List topNPages = websiteAnalyzer.getTopNPages(3);
		assertTrue(topNPages.size() == 2);
	}

	@Test
	public void validateSizeWithEmptyUrl() {
		websiteAnalyzer.reportPageAccess("");
		websiteAnalyzer.reportPageAccess("www.google.com");
		websiteAnalyzer.reportPageAccess("www.google.com");
		List topNPages = websiteAnalyzer.getTopNPages(3);
		assertTrue(topNPages.size() == 2);
	}

}
