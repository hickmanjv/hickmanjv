//
//  main.swift
//  function greet
//
//  Created by Joshua Hickman on 6/19/20.
//  Copyright © 2020 Joshua Hickman. All rights reserved.
//

import Foundation

func greet(person name: String, greeting: String) -> String {
    return greeting + " " + name
}

print(greet(person: "Karen", greeting: "Hello"))

func convertMilesToKilometers(_ miles: Double) -> Double {
    return miles * 1.60934
}

var km = convertMilesToKilometers(150)

print(km)

struct Size {
    var width = 0.0, height = 0.0
}

let size1 = Size()

//size1.width = 12.4

print(size1.width)

class VideoMode {
    var resolution = Size()
    var interlaced = false
    var frameRate = 0.0
    var name: String?
}

let someVideo = VideoMode()

someVideo.resolution.width = 12.4

print(someVideo.resolution.width)


struct TravelPhoto {
    let latitude, longitude : Double
    let title, description, image, urlString : String
}

let photo1 = TravelPhoto(latitude: 38.94733, longitude: -92.328466, title: "The Mizzou Columns", description: "University of Missouri six iconic columns", image: "columns.png", urlString: "http://missouri.edu/about/history/columns.php")

print(photo1)


class Document {
    var title : String
    var body : String = ""
    var length : Int { body.count }     //do not need return b/c of closure rules
    
    init(title:String) {
        self.title = title
    }
    
    init(title:String, body:String) {
        self.title = title
        self.body = body
    }
    
}

let document1 = Document(title: "Hello World")
document1.title = "Hello World!"
document1.body = "I awoke from a digital slumber."
let document2 = Document(title: "The Day", body: "It was a day to remember.")
print(document1.title)
print(document1.body)
print(document1.length)
print(document2.title)
print(document2.length)


// assigning a mutable array of colors
var colors = ["red", "orange", "yellow", "pink"]

// removing pink from the array
colors.removeLast()

// add green to the end of the array
colors.append("green")

// assigning a constant with the number of colors in the colors array
let numColors = colors.count

// printing the number of colors in colors array
print("number of colors = \(numColors)")

// print the heading for colors
print("colors:")

// iterate through and print out each single color of the array
for value in colors {
    print(value)
}

// assigning a non-mutable array
let moreColors = ["blue", "purple"]

// combining the two different arrays into a single one
var allColors = colors + moreColors

// print the heading for all colors
print("all colors:")

// iterate through and print out each single color of the combined array
for value in allColors {
    print(value)
}

/***************************************/

// create an empty dictionary
var states = [String: String]()

// adding key-values to the collection
states["MO"] = "Missouri"
states["PA"] = "Pennsylvania"
states["CA"] = "California"

// printing the dictonary with formating
for state in states {
    print(state.key + " is " + state.value)
}

// variable to collect an array of keys
var codes = [String]()

// adding each key in dictionary to codes variable
for key in states.keys {
    codes.append(key)
}

// assigning a constant array with the key values in codes
let stateCodes = codes

// printing each element of the array
for state in stateCodes {
    print(state)
}

// removing key-value from dictionary using assign nil method
states["PA"] = nil

// removing key-value from dictionary using built-in dictionary function
states.removeValue(forKey: "MO")

// printing the dictonary with formatting
for state in states {
    print(state.key + " is " + state.value)
}

var latitude = 90.3222, longitude = 1.323434, altitude = 7834.23

print(latitude)
print(altitude)

var i, j, k: Double

print(type(of:i))

for index in 4..<8 {
    print(index)
}

func add(_ value1: Int, to value2: Int) -> Int {
    return value1 + value2
}

let total = add(5, to: 6)

print(total)

func add(_ x: Int, _ y: Int) -> Int {
    return x + y
}

let result = add(5,6)

print(result)

let error = (errorCode: 101, message: "Invalid value.")

let (code, message) = error

print(code)

print(error.1)

print(error.message)

var name: String? = "Dale"

if let name = name{
    print(name)
}

var price : Float! = 10.00
var weight : Float! = 4.0

let cost = price * weight

print(cost)
