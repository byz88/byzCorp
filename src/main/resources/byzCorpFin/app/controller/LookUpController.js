/*
 * File: app/controller/LookUpController.js
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

Ext.define('byzCorp.controller.LookUpController', {
    extend: 'BaseController',

    id: 'LookUpController',

    control: {
        "#searchLookUpGrid": {
            keyup: 'onSearchLookUpGridKeyup'
        },
        "#bntLookUpDetailSaveOrUpdate": {
            click: 'onBntLookUpDetailSaveOrUpdateClick'
        },
        "#btnLookUpDetailRemove": {
            click: 'onBtnLookUpDetailRemoveClick'
        },
        "#lookUpGrid": {
            rowclick: 'onLookUpGridRowClick'
        },
        "#lookUpDetailGrid": {
            rowclick: 'onLookUpDetailGridRowClick'
        },
        "#provinceId": {
            change: 'onProvinceIdChange'
        }
    },

    onSearchLookUpGridKeyup: function(textfield, e, eOpts) {
        var query = Ext.getCmp("searchLookUpGrid").getValue();
        var lookUpGrid = Ext.getCmp("lookUpGrid");
        lookUpGrid.getStore().load({
            params:{
                query : query
            }
        });
    },

    onBntLookUpDetailSaveOrUpdateClick: function(button, e, eOpts) {
        var scope = this;
        var lookUpSelected = Ext.getCmp("lookUpGrid").getSelectionModel().getSelection();
        if(lookUpSelected.length==0){
            scope.showWarningMessage("Tanım listesinden kayıt seçiniz.");
            return;
        }
        var lookUpDetailGridAdd = Ext.getCmp("lookUpDetailGridAdd");
        var lookUpId = Ext.encode(lookUpSelected[0].data.lookUpId);
        Ext.Ajax.request({
            url:'/byzCorp/lookUp/saveOrUpdateLookUpDetail',
            params : {
                data : Ext.encode(lookUpDetailGridAdd.getForm().getValues()),
                lookUpId : lookUpId
            },
            success : function(response){
                var jsonData = Ext.util.JSON.decode(response.responseText.trim());
                if(jsonData.success){
                    var grid = Ext.getCmp("lookUpDetailGrid");
                    grid.getStore().load({
                        params:{
                            lookUpId : lookUpId
                        }
                    });
                    lookUpDetailGridAdd.getForm().reset();
                    scope.showSuccessMessage();
                    Ext.getCmp("name").focus();
                }else{
                 scope.showErrorMessage(jsonData.message);
                 Ext.getCmp("name").focus();
                }
            },
            failure: function (response) {
                var jsonData = Ext.util.JSON.decode(response.responseText.trim());
                scope.showErrorMessage(jsonData.message);
                Ext.getCmp("name").focus();
            }
        });
    },

    onBtnLookUpDetailRemoveClick: function(button, e, eOpts) {
        var scope = this;
        var lookUpDetailSelected = Ext.getCmp("lookUpDetailGrid").getSelectionModel().getSelection();
        var lookUpSelected = Ext.getCmp("lookUpGrid").getSelectionModel().getSelection();
        if(lookUpDetailSelected.length==0){
            this.showWarningMessage('Tanım listesinden kayıt seçiniz.');
        }
        var lookUpDetailGridAdd = Ext.getCmp("lookUpDetailGridAdd");
        var lookUpId = Ext.encode(lookUpSelected[0].data.lookUpId);
        Ext.Ajax.request({
            url:'/byzCorp/lookUp/removeLookUpDetail',
            params : {
                lookUpDetailId : Ext.encode(lookUpDetailSelected[0].data.lookUpDetailId)
            },
            success : function(response){
                var jsonData = Ext.util.JSON.decode(response.responseText.trim());
                if(jsonData.success){
                    var grid = Ext.getCmp("lookUpDetailGrid");
                    grid.getStore().load({
                        params:{
                            lookUpId : lookUpId
                            }
                    });
                lookUpDetailGridAdd.getForm().reset();
                scope.showSuccessMessage();
                Ext.getCmp("name").focus();
                }else{
                 scope.showErrorMessage(jsonData.message);
                 Ext.getCmp("name").focus();
                }
            },
            failure: function (response) {
                var jsonData = Ext.util.JSON.decode(response.responseText.trim());
                scope.showErrorMessage(jsonData.message);
                Ext.getCmp("name").focus();
            }
        });
    },

    onLookUpGridRowClick: function(tableview, record, element, rowIndex, e, eOpts) {
        var grid = Ext.getCmp("lookUpDetailGrid");
        grid.getStore().load({
            params:{
                lookUpId: record.data.lookUpId
            }
        });
        Ext.getCmp("lookUpDetailGridAdd").getForm().reset();
    },

    onLookUpDetailGridRowClick: function(tableview, record, element, rowIndex, e, eOpts) {
        Ext.getCmp("lookUpDetailGridAdd").getForm().setValues(record.data);
    },

    onProvinceIdChange: function(field, newValue, oldValue, eOpts) {
        var scope = this;
        debugger;
        var countryId = Ext.getCmp("countryId").getValue();
        if(countryId == ""){
            scope.showWarningMessage("Öncelikle il seçimi yapmalısınız.");
            return;
        }
        field.getStore().addListener('beforeload', function(store, option){
            option.params_counrtyId = countryId;
        });

    }

});
