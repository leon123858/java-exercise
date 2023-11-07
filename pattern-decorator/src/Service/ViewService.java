package Service;

import TextView.Element;
import TextView.ViewDecorator;

import java.util.ArrayList;

public class ViewService {
    private ViewDecorator[] views;

    public ViewService() {
        this.views = new ViewDecorator[0];
    }

    public void addView(ViewDecorator view) {
        // check if view name already exists
        for (ViewDecorator existingView : this.views) {
            if (existingView.name.equals(view.name)) {
                throw new IllegalArgumentException("View name already exists");
            }
        }
        ViewDecorator[] newViews = new ViewDecorator[this.views.length + 1];
        System.arraycopy(this.views, 0, newViews, 0, this.views.length);
        newViews[this.views.length] = view;
        this.views = newViews;
    }

    public void addViewElement(String viewName, Element element) {
        for (ViewDecorator view : this.views) {
            if (view.name.equals(viewName)) {
                view.addElement(element);
                return;
            }
        }
        throw new IllegalArgumentException("View not found");
    }

    public void display(String viewName) {
        for (ViewDecorator view : this.views) {
            if (view.name.equals(viewName)) {
                view.draw(new ArrayList<>());
                return;
            }
        }
        throw new IllegalArgumentException("View not found");
    }
}
