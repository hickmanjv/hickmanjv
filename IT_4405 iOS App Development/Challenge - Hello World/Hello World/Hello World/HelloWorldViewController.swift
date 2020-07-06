//
//  ViewController.swift
//  Hello World
//
//  Created by Joshua Hickman on 6/22/20.
//  Copyright © 2020 Joshua Hickman. All rights reserved.
//

import UIKit

class HelloWorldViewController: UIViewController {
    
    @IBOutlet weak var displayLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


    @IBAction func doHello(_ sender: UIButton) {
        displayLabel.text = "Hello World!"
    }
    
    
    @IBAction func doClear(_ sender: UIButton) {
        displayLabel.text = ""
    }
    
    
}

