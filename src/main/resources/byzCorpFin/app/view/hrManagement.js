/*
 * File: app/view/hrManagement.js
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

Ext.define('byzCorp.view.hrManagement', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.hrManagement',

    requires: [
        'byzCorp.view.hrManagementViewModel',
        'byzCorp.view.generalPagingToolbar',
        'Ext.grid.Panel',
        'Ext.grid.column.Check',
        'Ext.view.Table',
        'Ext.form.Panel',
        'Ext.form.field.Text',
        'Ext.button.Button',
        'Ext.menu.Menu',
        'Ext.menu.Item',
        'Ext.toolbar.Paging'
    ],

    viewModel: {
        type: 'hrmanagement'
    },
    height: 759,
    width: 921,
    layout: 'border',
    title: 'Hr Management',

    items: [
        {
            xtype: 'gridpanel',
            margins: '',
            region: 'center',
            id: 'hrGrid',
            margin: '0 2 0 0',
            autoLoad: true,
            store: 'userDetail',
            columns: [
                {
                    xtype: 'gridcolumn',
                    flex: 2,
                    hidden: true,
                    width: 147,
                    dataIndex: 'userId',
                    text: 'userId'
                },
                {
                    xtype: 'gridcolumn',
                    flex: 1,
                    dataIndex: 'identityNo',
                    text: 'T.C. Kimlik No'
                },
                {
                    xtype: 'gridcolumn',
                    flex: 3,
                    width: 250,
                    dataIndex: 'firstAndLastName',
                    text: 'Adı Soyadı'
                },
                {
                    xtype: 'gridcolumn',
                    flex: 2,
                    width: 208,
                    dataIndex: 'userName',
                    text: 'Kullanıcı Adı'
                },
                {
                    xtype: 'checkcolumn',
                    flex: 1,
                    dataIndex: 'status',
                    text: 'Statü'
                }
            ],
            dockedItems: [
                {
                    xtype: 'form',
                    dock: 'top',
                    height: 32,
                    id: 'hrGridSearch',
                    margin: '3 0 3 0',
                    width: 325,
                    layout: 'border',
                    bodyPadding: 10,
                    dockedItems: [
                        {
                            xtype: 'textfield',
                            dock: 'top',
                            id: 'searchHrGrid',
                            emptyText: 'Ara..',
                            enableKeyEvents: true
                        }
                    ]
                },
                {
                    xtype: 'form',
                    dock: 'top',
                    height: 34,
                    id: 'hrGridButtonForm',
                    margin: '0 0 3 0',
                    width: 325,
                    layout: 'border',
                    bodyPadding: 10,
                    dockedItems: [
                        {
                            xtype: 'button',
                            dock: 'left',
                            itemId: 'btnHrSaveOrUpdateWindow',
                            margin: '0 2 0 0',
                            maxWidth: 150,
                            minWidth: 150,
                            iconCls: 'fa fa-plus-square',
                            text: 'Ekle / Güncelle'
                        },
                        {
                            xtype: 'button',
                            dock: 'left',
                            maxWidth: 150,
                            minWidth: 150,
                            ui: 'dashboardWarningRed-small',
                            iconCls: 'fa fa-minus-square',
                            text: 'Sil'
                        },
                        {
                            xtype: 'button',
                            margins: '0 2 0 0',
                            dock: 'right',
                            maxWidth: 150,
                            minWidth: 150,
                            ui: 'dashboardWarningMagenta-small',
                            iconCls: 'fa fa-print',
                            text: 'Yazdır',
                            menu: {
                                xtype: 'menu',
                                items: [
                                    {
                                        xtype: 'menuitem',
                                        iconCls: 'fa fa-info',
                                        text: 'Personel Kartı'
                                    },
                                    {
                                        xtype: 'menuitem',
                                        iconCls: 'fa fa-list-ol',
                                        text: 'Personel Listesi'
                                    }
                                ]
                            }
                        }
                    ]
                },
                {
                    xtype: 'generalPagingToolbar',
                    dock: 'bottom'
                }
            ]
        },
        {
            xtype: 'panel',
            region: 'west',
            split: true,
            margin: '2 0 0 2',
            width: 299,
            collapsed: true,
            collapsible: true,
            iconCls: 'fa fa-search',
            title: 'Detaylı Ara'
        }
    ]

});