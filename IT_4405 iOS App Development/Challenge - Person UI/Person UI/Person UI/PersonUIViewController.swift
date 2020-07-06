//
//  ViewController.swift
//  Person UI
//
//  Created by Joshua Hickman on 6/29/20.
//  Copyright © 2020 Joshua Hickman. All rights reserved.
//

import UIKit

class PersonUIViewController: UIViewController {

    // outlet for label that displays age
    @IBOutlet weak var displayAgeLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    /* function that will change the value of the age
       label to the current value of the slider */
    @IBAction func changeAgeSlider(_ sender: UISlider) {
        /* assigning the current value of the slider to
           a variable. Type casting as Integer in case
           extra functionality required at future date.*/
        let slidervalue = Int(sender.value)
        
        // change label text to obtained slider value
        displayAgeLabel.text = String(slidervalue)
    }
}

