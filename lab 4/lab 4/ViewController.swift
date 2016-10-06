//
//  ViewController.swift
//  lab 4
//
//  Created by Eugene Ho on 27/9/2016.
//  Copyright © 2016 Eugene Ho. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var colorLabel: UILabel!
    @IBOutlet weak var movieLabel: UILabel!
    @IBOutlet weak var appLabel: UILabel!
    
    var user = Favourite()
    
    @IBAction func unwindSegue (segue:UIStoryboardSegue){
        colorLabel.text=user.favColor
        movieLabel.text=user.favMovie
        appLabel.text=user.favApp
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

