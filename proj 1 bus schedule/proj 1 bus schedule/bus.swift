//
//  bus.swift
//  proj 1 bus schedule
//
//  Created by Eugene Ho on 9/10/2016.
//  Copyright © 2016 Eugene Ho. All rights reserved.
//

import UIKit

class bus {
    
    var hour: Int
    var minute: Int
    var second: Int
    var timeTillArrival: NSDate
    var today : NSDate
    var formatedTime : String
    
    init(hour: Int, minute: Int, second: Int) {
        self.hour = hour
        self.minute = minute
        self.second = second
        self.today = NSDate.init()
        
        let cal: NSCalendar = NSCalendar(calendarIdentifier: NSCalendarIdentifierGregorian)!
        self.timeTillArrival = cal.dateBySettingHour(hour, minute: minute, second: second, ofDate: today, options: NSCalendarOptions())!
        self.formatedTime = "N/A"
        stringFromTimeInterval(timeTillArrival.timeIntervalSinceNow)
    }

      func stringFromTimeInterval(interval: NSTimeInterval) {
        let interval = Int(interval)
        let seconds = interval % 60
        let minutes = (interval / 60) % 60
        let hours = (interval / 3600)
        self.formatedTime = String(format: "%02d:%02d:%02d", hours, minutes, seconds)
    }
}
