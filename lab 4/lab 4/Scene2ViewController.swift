//
//  Scene2ViewController.swift
//  lab 4
//
//  Created by Eugene Ho on 27/9/2016.
//  Copyright © 2016 Eugene Ho. All rights reserved.
//

import UIKit

class Scene2ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var userColor: UITextField!
    @IBOutlet weak var userMovie: UITextField!
    @IBOutlet weak var userApp: UITextField!
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        if segue.identifier == "doneFavs"{
            let scene1ViewController = segue.destinationViewController as! ViewController
            //check to see that text was entered in the textfields
            if userColor.text!.isEmpty == false{ scene1ViewController.user.favColor=userColor.text
            }
            if userMovie.text!.isEmpty == false{
            scene1ViewController.user.favMovie=userMovie.text
            }
            if userApp.text!.isEmpty == false{
            scene1ViewController.user.favApp=userApp.text
            }
        }
    }
    
    override func viewDidLoad() {
        userColor.delegate = self
        userMovie.delegate = self
        userApp.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    func textFieldShouldReturn(textfield: UITextField) -> Bool{
        textfield.resignFirstResponder()
        return true
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}
