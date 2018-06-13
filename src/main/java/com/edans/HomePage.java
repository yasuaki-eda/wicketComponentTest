package com.edans;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.edans.dropdown.DropDownPage;
import com.edans.dropdown.DropDownPage2;
import com.edans.dropdown.DropDownPage3;
import com.edans.radio.RadioPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);
    }

	protected void onInitialize() {
		super.onInitialize();

		add(new Link<Void>("ddlPage") {

			@Override
			public void onClick() {
				setResponsePage(DropDownPage.class);
			}
		});

		add(new Link<Void>("ddlPage2") {

			@Override
			public void onClick() {
				setResponsePage(DropDownPage2.class);
			}
		});

		add(new Link<Void>("ddlPage3") {

			@Override
			public void onClick() {
				setResponsePage(DropDownPage3.class);
			}
		});

		add(new Link<Void>("radioPage") {

			@Override
			public void onClick() {
				setResponsePage(RadioPage.class);
			}
		});
	}



}
