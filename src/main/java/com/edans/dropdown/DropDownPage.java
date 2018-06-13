package com.edans.dropdown;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;

public class DropDownPage extends WebPage {

	private String morning;

	public DropDownPage() {
		Form<?> form = new Form<Void>("form");
		add(form);
		form.add(initDropDownChoice());
		form.add(new Label("selected", new PropertyModel<String>(this, "morning")));
		form.add(new Button("submit"));
	}

	private DropDownChoice<?> initDropDownChoice(){
		List<String> selectList = Arrays.asList("パン", "御飯", "抜き");
		DropDownChoice<?> ddc = new DropDownChoice<String>("dropDownChoice",
				new PropertyModel<String>(this, "morning"),
				selectList);
		return ddc;
	}

}
