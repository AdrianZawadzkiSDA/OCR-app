package pl.adrian.vaadinocr;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class AppView extends VerticalLayout {

    private OcrService ocrService;

    @Autowired
    public AppView(OcrService ocrService) {
        this.ocrService = ocrService;

        TextField textField = new TextField();
        textField.setWidth("600px");
        textField.setPlaceholder("url");

        Button rightButton = new Button("Check Image",
                new Icon(VaadinIcon.INSERT));
        rightButton.setIconAfterText(true);

        rightButton.addClickListener(event -> {
            Dialog dialog = new Dialog();
            dialog.setWidth("400px");
            dialog.setHeight("150px");
                    dialog.add(new Label( ocrService.doOCR(textField.getValue())));
                    dialog.open();
                }
        );

        add(textField);
        add(rightButton);

    }

}
