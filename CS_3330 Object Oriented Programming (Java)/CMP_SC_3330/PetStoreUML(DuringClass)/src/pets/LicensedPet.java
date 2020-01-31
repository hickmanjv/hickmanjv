/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pets;

import java.time.LocalDateTime;

/**
 *
 * @author josh
 */
public interface LicensedPet {
    
    // interfaces can be used as a type
    // in interfaces, the default is public (only one that does this others used no-modifier
    
    Boolean isLicensed();
    void assignLicense();
    LocalDateTime whenLicensed();
}
