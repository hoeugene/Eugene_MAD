//
//  busTableViewCell.swift
//  proj 1 bus schedule
//
//  Created by Eugene Ho on 9/10/2016.
//  Copyright © 2016 Eugene Ho. All rights reserved.
//

import UIKit

class busTableViewCell: UITableViewCell {

    @IBOutlet weak var busTime: UILabel!
    @IBOutlet weak var timeTillArrival: UILabel!
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
//        timeTillArrival.text = busTime.text
    }

    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
