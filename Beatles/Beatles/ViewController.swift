//
//  ViewController.swift
//  Beatles
//
//  Created by Eugene Ho on 8/9/2016.
//  Copyright © 2016 Eugene Ho. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var titlelabel: UILabel!
    @IBOutlet weak var beatlesimage: UIImageView!
    @IBOutlet weak var imageControl: UISegmentedControl!
    @IBOutlet weak var capitalSwitch: UISwitch!
    @IBOutlet weak var fontSizeLabel: UILabel!
    
    
    @IBAction func updateCaps() {
        if capitalSwitch.on {
            titlelabel.text=titlelabel.text?.uppercaseString
        } else {
            titlelabel.text=titlelabel.text?.lowercaseString
        }
    }

    @IBAction func changeFontSize(sender: UISlider) {
        let fontSize=sender.value //float
        fontSizeLabel.text=String(format: "%.0f", fontSize) //convert float to String
        let fontSizeCGFloat=CGFloat(fontSize) //convert float to CGFloat
        titlelabel.font=UIFont.systemFontOfSize(fontSizeCGFloat) //create a UIFont object and assign to the font property
    }
    
    @IBAction func updateFont(sender: UISwitch) {
        updateCaps()
    }
    
    func updateImage (){
        if imageControl.selectedSegmentIndex==0 {
            titlelabel.text="Text"
            beatlesimage.image=UIImage(named: "text")
        } else if imageControl.selectedSegmentIndex==1 {
            titlelabel.text="Person"
            beatlesimage.image=UIImage(named: "person")
        }
    }
    
    @IBAction func changeinfo(sender: UISegmentedControl) {
        updateImage()
        updateCaps()
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

