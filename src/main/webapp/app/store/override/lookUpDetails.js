Ext.define('byzCorp.store.lookUpDetails', {
    extend: 'Ext.data.Store',

    requires: [
        'byzCorp.model.lookUpDetails',
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Json'
    ],

    constructor: function(cfg) {
        var me = this;debugger;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            storeId: 'lookUpDetails',
            asynchronousLoad: false,
            model: 'byzCorp.model.lookUpDetails',
            proxy: {
                type: 'ajax',
                extraParams: {
                    lookUpId: cfg
                },
                url: '/byzCorp/lookUp/getLookUpDetails',
                reader: {
                    type: 'json',
                    keepRawData: false,
                    rootProperty: 'data'
                }
            }
        }, cfg)]);
    }
});