<?php

class Omg {

    public function god() {
    }

}

class myClass {
    /**
     * @var Omg[]
     */
    private $retObjArray;

    public function testHinting()
    {
        $myArr = $this->retObjArray();

        foreach ($myArr as $a)
        {
            $a->otherFunc(); // myClass type hinting works here (yay!)
        }

        foreach ($this->retObjArray as $b)
        {
            $b->god();
        }
    }
}
?>