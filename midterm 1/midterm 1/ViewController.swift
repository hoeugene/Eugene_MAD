//
//  ViewController.swift
//  midterm 1
//
//  Created by Eugene Ho on 13/10/2016.
//  Copyright © 2016 Eugene Ho. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    @IBOutlet weak var workoutTime: UITextField!
    @IBOutlet weak var milesRan: UILabel!
    @IBOutlet weak var caloriesBurned: UILabel!
    @IBOutlet weak var weeklySwitch: UISwitch!
    @IBOutlet weak var activityControl: UISegmentedControl!
    @IBOutlet weak var activityImg: UIImageView!
    
    var activitySpeed = 10
    var calBurnPerHour = 10
    
    @IBAction func changeActivity(sender: UISegmentedControl) {
        if activityControl.selectedSegmentIndex==0 {
            activitySpeed = 10
            calBurnPerHour = 10
            activityImg.image=UIImage(named: "run.png")
        } else if activityControl.selectedSegmentIndex==1 {
            activitySpeed = 4
            calBurnPerHour = 51
            activityImg.image=UIImage(named: "swim.png")
        } else if activityControl.selectedSegmentIndex==2 {
            activitySpeed = 30
            calBurnPerHour = 42
            activityImg.image=UIImage(named: "bike.png")
        }
        updateCal()
    }
    
    func updateCal() {
        let minutesRan = Float(workoutTime.text!)
        let totalMiles = minutesRan!/Float(activitySpeed)
        let totalCal = minutesRan!*Float(calBurnPerHour)
        milesRan.text = String(format: "%.2f", totalMiles)
        caloriesBurned.text =  String(format: "%.2f", totalCal)
        
        if minutesRan < 30 {
            let alert=UIAlertController(title:"Slacker", message:"You should workout more than 30min", preferredStyle: UIAlertControllerStyle.Alert)
            let okAction = UIAlertAction(title:"OK", style:UIAlertActionStyle.Default, handler:nil)
            alert.addAction(okAction)
            presentViewController(alert, animated: true, completion: nil)
        }
    }
    
    @IBAction func weeklyButton(sender: UISwitch) {
        if weeklySwitch.on {
            milesRan.text =  String(Float(milesRan.text!)!*5)
            caloriesBurned.text =  String(Float(caloriesBurned.text!)!*5)
        } else {
            milesRan.text =  String(Float(milesRan.text!)!/5)
            caloriesBurned.text =  String(Float(caloriesBurned.text!)!/5)
        }
    }
    
    @IBAction func calWorkout(sender: UIButton) {
        updateCal()
    }
    
    func textFieldShouldReturn(textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    override func viewDidLoad() {
        workoutTime.delegate=self
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

