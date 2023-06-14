package de.neuefische.carspring.panel;

import com.google.gson.Gson;
import de.neuefische.carspring.controller.CarController;
import de.neuefische.carspring.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class Panel extends JPanel implements ActionListener {
    JButton listButton;
    JButton addButton;
    JButton deleteButton;
    JButton editButton;
    JTextArea output;
    JTextArea carInput;
    JTextField carId;

    @Autowired
    private CarController carController;

    public Panel() {
        this.setPreferredSize(new Dimension(750, 500));
        this.setBackground(Color.DARK_GRAY);

        this.output = new JTextArea(10, 25);
        this.carInput = new JTextArea();
        this.carId = new JTextField();

        output.setWrapStyleWord(true);
        output.setLineWrap(true);
        output.setText("Welcome to Snek Car Service");
        output.setEditable(false);
        output.setPreferredSize(new Dimension(500, 250));
        output.setCaretPosition(output.getDocument().getLength());

        carInput.setWrapStyleWord(true);
        carInput.setLineWrap(true);
        carInput.setText("new Car");
        carInput.setPreferredSize(new Dimension(500, 50));

        carId.setText("Car ID");
        carId.setPreferredSize(new Dimension(500, 50));

        JScrollBar areaScrollBar = new JScrollBar(Adjustable.VERTICAL);
        areaScrollBar.setPreferredSize(new Dimension(25, 25));
        JScrollPane areaScrollPane = new JScrollPane(output);
        areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setVerticalScrollBar(areaScrollBar);
        areaScrollPane.setPreferredSize(new Dimension(25, 250));



        addButton = new JButton("Add car");
        addButton.setBackground(Color.GREEN);
        addButton.addActionListener(this);

        listButton = new JButton("List cars");
        listButton.setBackground(Color.GRAY);
        listButton.addActionListener(this);

        editButton = new JButton("Edit car");
        editButton.setBackground(Color.BLUE);
        editButton.addActionListener(this);

        deleteButton = new JButton("Delete car");
        deleteButton.setBackground(Color.RED);
        deleteButton.addActionListener(this);

        this.add(addButton);
        this.add(listButton);
        this.add(editButton);
        this.add(deleteButton);
        this.add(carId);
        this.add(carInput);
        this.add(output);
        this.add(areaScrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.listButton) {
            output.setText(carController.list().toString());
        }
        if(event.getSource() == this.addButton) {
            Gson g = new Gson();
            Car newCar = g.fromJson(carInput.getText(), Car.class);
            carController.add(newCar);
        }
        if(event.getSource() == this.deleteButton) {
            carController.delete(carId.getText());
        }
        if(event.getSource() == this.editButton) {
            Gson g = new Gson();
            Car editCar = g.fromJson(carInput.getText(), Car.class);
            carController.edit(carId.getText(), editCar);
        }
        output.setText(carController.list().toString());
    }
}
