//
//  ViewController.swift
//  lab3 tip calculator
//
//  Created by Eugene Ho on 20/9/2016.
//  Copyright © 2016 Eugene Ho. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    @IBOutlet weak var checkAmount: UITextField!
    @IBOutlet weak var tipPercent: UITextField!
    @IBOutlet weak var people: UITextField!
    
    @IBOutlet weak var tipDue: UILabel!
    @IBOutlet weak var totalDue: UILabel!
    @IBOutlet weak var totalDuePerPerson: UILabel!
    
    func textFieldShouldReturn(textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    func updateTipTotals() {
        var amount:Float
        var pct:Float
        
        if checkAmount.text!.isEmpty {
            amount = 0.0
        } else {
            amount = Float(checkAmount.text!)!
        }
        if tipPercent.text!.isEmpty {
            pct = 0.0
        }
        else {
            pct = Float(tipPercent.text!)!/100
        }
        
        let numberOfPeople=Int(people.text!) //returns an optional
        let tip=amount*pct
        let total=amount+tip
        var personTotal : Float = 0.0 //specify Float so it's not a Double
        
        if numberOfPeople != nil {
            if numberOfPeople! > 0 {
                personTotal = total / Float(numberOfPeople!)
            } else {
            let alert=UIAlertController(title:"Warning", message:"Number of people must be greater than 0", preferredStyle: UIAlertControllerStyle.Alert)
            let cancelAction = UIAlertAction(title: "Cancel", style: UIAlertActionStyle.Cancel, handler: nil)
            alert.addAction(cancelAction)
            let okAction = UIAlertAction(title:"OK", style:UIAlertActionStyle.Default, handler: {action in self.people.text="1"; self.updateTipTotals()})
            alert.addAction(okAction)
            presentViewController(alert, animated: true, completion: nil)
            }
        }
        
        //format results as currency
        let currencyFormatter = NSNumberFormatter()
        currencyFormatter.numberStyle=NSNumberFormatterStyle.CurrencyStyle //set the number style
        tipDue.text=currencyFormatter.stringFromNumber(tip) //returns a formatted string
        totalDue.text=currencyFormatter.stringFromNumber(total)
        totalDuePerPerson.text=currencyFormatter.stringFromNumber(personTotal)
    }
    
    func textFieldDidEndEditing(textField: UITextField) {
        updateTipTotals()
    }
    
    override func viewDidLoad() {
        checkAmount.delegate=self
        tipPercent.delegate=self
        people.delegate=self
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func onTapGestureRecognized(sender: AnyObject) {
        checkAmount.resignFirstResponder()
        tipPercent.resignFirstResponder()
        people.resignFirstResponder()
    }
    
}

