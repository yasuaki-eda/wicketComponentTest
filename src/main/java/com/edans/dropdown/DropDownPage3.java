package com.edans.dropdown;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import com.edans.model.FoodType;

public class DropDownPage3 extends WebPage {

	private List<FoodType> list = new ArrayList<>();
	private FoodType selected;
	private Component selectLabel;

	public DropDownPage3() {

		addFoodList();

		Form<?> form = new Form<Void>("form");
		add(form);
		form.add(new DropDown3<>("dropDownChoice", new PropertyModel<FoodType>(this, "selected")));
		selectLabel = new Label("selected", new PropertyModel<String>(this, "selected.type"));
		selectLabel.setOutputMarkupId(true);
		form.add(selectLabel);
		form.add(new Button("submit"));

	}

	protected void addFoodList() {
		list.add(new FoodType(0, "ごはん", "和"));
		list.add(new FoodType(1, "パン", "洋"));
		list.add(new FoodType(2, "パスタ", "イタリアン"));
	}

	protected class DropDown3<T> extends DropDownChoice<FoodType>{
		public DropDown3(String id, IModel<FoodType> model) {
			super(id, model, list, new ChoiceRenderer<FoodType>("name", "id"));
			add(new AjaxFormComponentUpdatingBehavior("change") {
				@Override
				protected void onUpdate(AjaxRequestTarget target) {
					target.add(selectLabel);
				}
			});
		}
	}


}
