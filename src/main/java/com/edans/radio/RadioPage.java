package com.edans.radio;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.model.PropertyModel;

public class RadioPage extends WebPage {

	private String select;

	public RadioPage() {
		Form<?> form = new Form<Void>("form");
		add(form);
		form.add(new Label("selected", new PropertyModel<String>(this, "select")));
		form.add(new Button("submit"));
		RadioChoice<String> radio = new RadioChoice<String>("radio",
				new PropertyModel<String>(this, "select"),
				Arrays.asList("ケータイ", "スマホ", "黒電話"));
		form.add(radio);
	}


}
