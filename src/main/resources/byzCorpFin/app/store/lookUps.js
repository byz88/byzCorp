/*
 * File: app/store/lookUps.js
 *
 * This file was generated by Sencha Architect version 4.2.3.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 6.5.x Classic library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 6.5.x Classic. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('byzCorp.store.lookUps', {
    extend: 'Ext.data.Store',

    requires: [
        'byzCorp.model.lookUps',
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Json'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            storeId: 'lookUps',
            asynchronousLoad: false,
            model: 'byzCorp.model.lookUps',
            proxy: {
                type: 'ajax',
                url: '/byzCorp/lookUp/getLookUps',
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8',
                    'Accept-Language': 'tr-TR,en;q=0.9,tr;q=0.8'
                },
                reader: {
                    type: 'json',
                    rootProperty: 'data'
                }
            }
        }, cfg)]);
    }
});