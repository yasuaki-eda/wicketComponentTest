package com.edans.dropdown;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import com.edans.model.FoodType;

public class DropDownPage2 extends WebPage {

	private List<FoodType> list = new ArrayList<>();
	private FoodType selected;

	public DropDownPage2() {

		addFoodList();

		Form<?> form = new Form<Void>("form");
		add(form);
		form.add(new DropDown2<>("dropDownChoice", new PropertyModel<FoodType>(this, "selected")));
		form.add(new Label("selected", new PropertyModel<String>(this, "selected.type")));
		form.add(new Button("submit"));

	}

	protected void addFoodList() {
		list.add(new FoodType(0, "ごはん", "和"));
		list.add(new FoodType(1, "パン", "洋"));
		list.add(new FoodType(2, "パスタ", "イタリアン"));
	}

	protected class DropDown2<T> extends DropDownChoice<FoodType>{
		public DropDown2(String id, IModel<FoodType> model) {
			super(id, model, list, new ChoiceRenderer<FoodType>("name", "id"));
		}
	}




}
