//
//  ViewController.swift
//  vinci
//
//  Created by Man Hon Eugene Ho on 8/30/16.
//  Copyright © 2016 Man Hon Eugene Ho. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var artImage: UIImageView!
    
    @IBAction func chooseArt(sender: UIButton) {
        if sender.currentTitle == "Monalisa"{
            artImage.image=UIImage(named:"daVinci_MonaLisa.png")
        }
        else if sender.currentTitle == "Vitruvian"{
            artImage.image=UIImage(named:"daVinci_Vitruvian.png")
        }
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

