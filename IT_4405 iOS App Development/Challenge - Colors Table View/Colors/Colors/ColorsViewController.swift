//
//  ViewController.swift
//  Colors
//
//  Created by Joshua Hickman on 7/1/20.
//  Copyright © 2020 Joshua Hickman. All rights reserved.
//

import UIKit

class ColorsViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    var colors = [Color(name: "red", uiColor: UIColor.red),
                  Color(name: "orange", uiColor: UIColor.orange),
                  Color(name: "yellow", uiColor: UIColor.yellow),
                  Color(name: "green", uiColor: UIColor.green),
                  Color(name: "blue", uiColor: UIColor.blue),
                  Color(name: "purple", uiColor: UIColor.purple),
                  Color(name: "brown", uiColor: UIColor.brown)]

    /* -------- Better implementation above ---------
     
    // array of colors for the table
    let colors = ["red", "orange", "yellow", "green", "blue",
                  "purple", "brown"]
    
    // corresponding array that matches the sequence of the colors array
    let useableColors = [UIColor.red, UIColor.orange, UIColor.yellow, UIColor.green, UIColor.blue, UIColor.purple, UIColor.brown]
     
    */
    
    /* Wanted to manually code the datasource and delegate to have some more practice with the syntax of the language */
    @IBOutlet weak var colorsTableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //self.title = "Colors"
       
        // assigning this view controller as the datasource and delegate
        colorsTableView.dataSource = self
        colorsTableView.delegate = self
    }
    
    // only 1 section of the table
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    /* function to get number of cells needed for the table based on
       the colors array */
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
    
        return colors.count
    }

    // Function that sets up how the cell will look when displayed
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "colorCell", for: indexPath)
        
        // Pulling an instance of the array object so we don't
        // have to make 2 calls to the array for name & color
        let color = colors[indexPath.row]
        
        // setting the cell text to the color name
        cell.textLabel?.text = color.name

        // setting the cell background color with the corresponding
        // UIColor that matches the name
        cell.backgroundColor = color.uiColor
        
        // prevents the grey cell after selection
        cell.selectionStyle = .none
        
        return cell
    }
    
    // can stop the grey cell this way, but the cell.selectionStyle more efficient
    /*
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.cellForRow(at: indexPath)?.isSelected = false
    }
    */
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if let destination = segue.destination as? ColorDetailViewController,
           let row = colorsTableView.indexPathForSelectedRow?.row
        {
            destination.color = colors[row]
        }
    }

}

