package com.telran.qaq6;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{


    @Test
    public void  test1(){
        goToGroupsPage();
        if(!isGroupPresent()){
            createGroup();
        }
        selectGroup();
        groupDeletion();
        returnToTheGroupsPage();



        }



    }





