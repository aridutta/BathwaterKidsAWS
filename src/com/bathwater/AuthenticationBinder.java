/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bathwater;

import java.util.Random;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.bathwater.dynamodb.helper.IDynamoDBHelper;
import com.bathwater.dynamodb.helper.impl.DynamoDBHelper;
import com.bathwater.dynamodb.helper.queries.DynamoDBQueries;
import com.bathwater.dynamodb.helper.queries.DynamoDBScans;
import com.bathwater.dynamodb.helper.queries.IDynamoDBQueries;
import com.bathwater.dynamodb.helper.queries.IDynamoDBScans;
import com.bathwater.elasticsearch.helper.queries.ESItemQueries;
import com.bathwater.elasticsearch.helper.queries.IESItemQueries;

/**
 *
 * @author rajeshk
 */
public class AuthenticationBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(new AuthenticationService()).to(AuthenticationService.class);
        bind(DynamoDBHelper.class).to(IDynamoDBHelper.class);
        bind(DynamoDBScans.class).to(IDynamoDBScans.class);
        bind(DynamoDBQueries.class).to(IDynamoDBQueries.class);
        bind(ESItemQueries.class).to(IESItemQueries.class);     
        bind(Random.class).to(	Random.class);
    }
    
}
