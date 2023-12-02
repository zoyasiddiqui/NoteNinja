// Package declaration
package view;

// Import statements for various classes and interfaces
import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// Class declaration for ViewManager implementing PropertyChangeListener
public class ViewManager implements PropertyChangeListener {
    // Instance variables for card layout, JPanel views, and ViewManagerModel
    private final CardLayout cardLayout;
    private final JPanel views;
    private ViewManagerModel viewManagerModel;

    // Constructor for ViewManager
    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        // Initialization of instance variables
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addPropertyChangeListener(this);
    }

    // PropertyChangeListener method implementation
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Check if the property change is related to the "view" property
        if (evt.getPropertyName().equals("view")) {
            // Get the new value of the "view" property
            String viewModelName = (String) evt.getNewValue();

            // Use CardLayout to show the view associated with the new value
            cardLayout.show(views, viewModelName);
        }
    }
}
