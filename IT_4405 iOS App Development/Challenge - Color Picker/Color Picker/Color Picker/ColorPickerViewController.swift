//
//  ViewController.swift
//  Color Picker
//
//  Created by Joshua Hickman on 7/5/20.
//  Copyright © 2020 Joshua Hickman. All rights reserved.
//

import UIKit

class ColorPickerViewController: UIViewController, UIPickerViewDataSource, UIPickerViewDelegate {
    
    // array of Color struct objects that match a UI color with a string name for the color
    var colors = [Color(name: "red", uiColor: UIColor.red),
                  Color(name: "orange", uiColor: UIColor.orange),
                  Color(name: "yellow", uiColor: UIColor.yellow),
                  Color(name: "green", uiColor: UIColor.green),
                  Color(name: "blue", uiColor: UIColor.blue),
                  Color(name: "purple", uiColor: UIColor.purple)]
    
    @IBOutlet weak var colorsPickerView: UIPickerView!
    
    @IBOutlet weak var colorLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        // manually assigning datasource and delegate
        colorsPickerView.dataSource = self
        colorsPickerView.delegate = self
        
        // initializing the color label and screen to represent the first color in the array
        colorLabel.text = colors[0].name
        self.view.backgroundColor = colors[0].uiColor
    }
    
    // setting the number of columns of the color picker
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    // setting the number of items in the picker wheel to the number of items in the array
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return colors.count
    }

    // setting the title of each picker row to the color names of the colors array
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        
        // don't need to waste the resources to create a variable here, since
        // it only calls the array once to set the name and nothing else
        
        //let color = colors[row]
        
        // return color.name
        
        return colors[row].name
    }
    
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        
        // assigning the instance of the Color to a variable so we aren't accessing the array twice
        let color = colors[row]
        
        // sets the color label's name to that of the assinged color
        colorLabel.text = color.name
        // sets the entire backgorund color to the corresponding color
        // colorsPickerView.backgroundColor only changes the small picker section
        self.view.backgroundColor = color.uiColor
    }
    
}

