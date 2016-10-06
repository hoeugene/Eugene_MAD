//
//  ViewController.swift
//  proj 5 map
//
//  Created by Eugene Ho on 4/10/2016.
//  Copyright © 2016 Eugene Ho. All rights reserved.
//

import UIKit
import MapKit
import CoreLocation

class ViewController: UIViewController, CLLocationManagerDelegate {

    @IBOutlet weak var mapView: MKMapView!
    
    var locationManager = CLLocationManager()
    
    override func viewDidLoad() {
        mapView.mapType = MKMapType.Satellite
        let status = CLLocationManager.authorizationStatus()
        if status == CLAuthorizationStatus.NotDetermined {
            locationManager.requestWhenInUseAuthorization()
        }
        locationManager.delegate = self
        locationManager.desiredAccuracy = kCLLocationAccuracyBest
        locationManager.distanceFilter = kCLDistanceFilterNone // Distance device must move to update
        
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    // Update location
    func locationManager(manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        let span = MKCoordinateSpanMake(0.05, 0.05)
        let region = MKCoordinateRegionMake(manager.location!.coordinate,span)
        mapView.setRegion(region, animated: true)
    }
    
    // Ask for authorization
    func locationManager(manager: CLLocationManager, didChangeAuthorizationStatus status: CLAuthorizationStatus) {
        print("didchangeauth")
        if status == CLAuthorizationStatus.AuthorizedWhenInUse {
            locationManager.startUpdatingLocation()
        }
    }
    
    func locationManager(manager: CLLocationManager, didFailWithError error: NSError) {
        var errorMessage = String()
        if let clError = CLError(rawValue: error.code) {
            if clError == .Denied {
                errorMessage = "access denied"
                let alert = UIAlertController(title: "Error", message: errorMessage, preferredStyle: UIAlertControllerStyle.Alert)
                let okAction:UIAlertAction = UIAlertAction(title: "OK", style: UIAlertActionStyle.Default , handler: nil)
                alert.addAction(okAction)
                presentViewController(alert, animated: true, completion: nil)
            }
        }
    }
    
    
//    override func viewDidLoad() {
//        mapView.mapType = MKMapType.Satellite
//        let status = CLLocationManager.authorizationStatus()
//        if status == CLAuthorizationStatus.NotDetermined {
//            locationManager.requestWhenInUseAuthorization()
//        }
//        locationManager.delegate = self
//        locationManager.desiredAccuracy = kCLLocationAccuracyBest
//        locationManager.distanceFilter = kCLDistanceFilterNone // Distance device must move to update
//        
//        super.viewDidLoad()
//        // Do any additional setup after loading the view, typically from a nib.
//    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

