package com.edans.radio;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormChoiceComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import com.edans.model.Phone;

public class RadioPage2 extends WebPage {

	private Phone select;
	private Label selectedLabel;
	private List<Phone> phoneList;

	public RadioPage2() {

		phoneList = listPhones();
		select = phoneList.get(1);

		Form<?> form = new Form<Void>("form");
		selectedLabel = new Label("selected", new PropertyModel<String>(this, "select.description"));
		selectedLabel.setOutputMarkupId(true);
		add(form);
		form.add(selectedLabel);
		form.add(new Button("submit"));
		form.add(new RadioChoice2("radio", new PropertyModel<Phone>(this, "select"), phoneList, selectedLabel));
	}

	List<Phone> listPhones(){
		List<Phone> list = new ArrayList<>();
		list.add(new Phone("ケータイ", 0, "携帯電話"));
		list.add(new Phone("スマホ", 1, "スマートフォン"));
		list.add(new Phone("黒電話", 2, "黒電話"));
		return list;
	}

	class RadioChoice2 extends RadioChoice<Phone> {
		public RadioChoice2 (String id, IModel<Phone> model, List<Phone> selectList, final Label selectedLabel) {
			super(id, model, selectList);
			setChoiceRenderer(new ChoiceRenderer<Phone>("name", "id"));
			add(new AjaxFormChoiceComponentUpdatingBehavior() {
				@Override
				protected void onUpdate(AjaxRequestTarget target) {
					target.add(selectedLabel);
				}
			});
		}

	}

}
