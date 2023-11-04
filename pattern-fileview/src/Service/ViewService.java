package Service;

import TextView.TextView;
import TextView.Element;

public class ViewService {
    private TextView[] views;

    public ViewService() {
        this.views = new TextView[0];
    }

    public void addView(TextView view) {
        // check if view name already exists
        for (TextView existingView : this.views) {
            if (existingView.name.equals(view.name)) {
                throw new IllegalArgumentException("View name already exists");
            }
        }
        TextView[] newViews = new TextView[this.views.length + 1];
        System.arraycopy(this.views, 0, newViews, 0, this.views.length);
        newViews[this.views.length] = view;
        this.views = newViews;
    }

    public void addViewElement(String viewName, Element element) {
        for (TextView view : this.views) {
            if(view.name.equals(viewName)) {
                view.addElement(element);
                return;
            }
        }
        throw new IllegalArgumentException("View not found");
    }

    public void display(String viewName) {
        for (TextView view : this.views) {
            if(view.name.equals(viewName)) {
                view.draw();
                return;
            }
        }
        throw new IllegalArgumentException("View not found");
    }
}
