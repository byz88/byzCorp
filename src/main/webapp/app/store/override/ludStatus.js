Ext.define('byzCorp.store.ludStatus', {
    extend: 'Ext.data.Store',

    requires: [
        'byzCorp.model.lookUpDetails',
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Json'
    ],

    constructor: function(cfg) {debugger;
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            storeId: 'ludStatus',
            asynchronousLoad: false,
            model: 'byzCorp.model.lookUpDetails',
            proxy: {
                type: 'ajax',
                extraParams: {
                    lookupIds: cfg.urlSuffix
                },
                url: '/byzCorp/lookUp/getLookUpDetails?lookUpId=1',
                reader: {
                    type: 'json',
                    keepRawData: false,
                    rootProperty: 'data'
                }
            }
        }, cfg)]);
    }
});