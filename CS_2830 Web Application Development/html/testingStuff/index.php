<?php
class myClass {

   protected $v1;  
   protected $v2; 
   protected $v3; 

   public function __construct($a, $b, $c) {
      $this->v1 = $a; 
      $this->v2 = $b; 
      $this->v3 = $c; 
   }

   protected function get_v1(){
      return $this->v1;
   }

   public function get_v2() {
      return $this->v2; 
   }

   public function get_v3() {
      return $this->v3; 
   }
}

$obj = new myClass();
$obj->get_v3();

//this is a comment
/* hjjb .   */
#comment 


?>