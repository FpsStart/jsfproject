     
            function onHourShowCallback(hour) {  
        if ((hour > 20) || (hour < 6)) {  
            return false; // not valid  
        }  
          
        return true; // valid  
    }  