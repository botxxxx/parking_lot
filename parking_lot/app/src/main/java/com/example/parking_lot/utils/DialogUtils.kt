package com.example.parking_lot.utils

import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.Html
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.example.parking_lot.R
import com.example.parking_lot.databinding.NormalAlertDialogBinding

/**
 * Created by NT30252 on 2017/10/3.
 */
object DialogUtils {
    private const val DIALOG_HEIGHT_RATIO = 0.9
    private const val DIALOG_LEFT_RIGHT_PADDING = 20
    private const val NORMAL_DIALOG_WIDTH = 460
    private const val OVERLAY_ALPHA = 0.408f

    fun getLoadingDialog(context: Context?): ProgressDialog {
        return ProgressDialog.show(context, "", context?.getString(R.string.loading_dialog), true)
    }

    fun showNotifyAlert(
        context: Context,
        title: String?,
        msg: String?,
        strYes: String?,
        listenerYes: DialogInterface.OnClickListener?
    ) {
        showAlert(context, true, title, msg, strYes, listenerYes, null, null, null)
    }

    fun showNotifyAlert(
        context: Context,
        msg: String?,
        strYes: String? = context.getString(R.string.btn_confirm),
        listenerYes: DialogInterface.OnClickListener? = null,
        strNo: String? = null,
        listenerNo: DialogInterface.OnClickListener? = null
    ) {
        showAlert(context, true, "", msg, strYes, listenerYes, strNo, listenerNo, null)
    }

    fun showNotifyAlert(
        context: Context,
        title: String?,
        msg: String?,
        strYes: String?,
        listenerYes: DialogInterface.OnClickListener?,
        strNo: String?,
        listenerNo: DialogInterface.OnClickListener?
    ) {
        showAlert(context, true, title, msg, strYes, listenerYes, strNo, listenerNo, null)
    }

    fun showNotifyAlert(
        context: Context,
        title: String?,
        msg: String?,
        strYes: String?,
        listenerYes: DialogInterface.OnClickListener?,
        strNo: String?,
        listenerNo: DialogInterface.OnClickListener?,
        listenerCancel: DialogInterface.OnCancelListener?
    ) {
        showAlert(context, true, title, msg, strYes, listenerYes, strNo, listenerNo, listenerCancel)
    }

    fun showNotifyAlert(context: Context, title: String?, msg: String?) {
        showAlert(context, true, title, msg, context.getString(R.string.btn_confirm), null, null, null, null)
    }

    fun showErrorAlert(context: Context, msg: String?) {
        showErrorAlert(context, "", msg, context.getString(R.string.btn_confirm), null)
    }

    fun showErrorAlert(context: Context, msg: String?, listenerYes: DialogInterface.OnClickListener?) {
        showErrorAlert(context, "", msg, context.getString(R.string.btn_confirm), listenerYes)
    }

    fun showErrorAlert(
        context: Context,
        title: String?,
        msg: String?,
        strYes: String? = "確認",
        listenerYes: DialogInterface.OnClickListener? = null,
        strNo: String? = null,
        listenerNo: DialogInterface.OnClickListener? = null
    ) {
        showAlert(context, true, title, msg, strYes, listenerYes, strNo, listenerNo, null)
    }

    fun showFreezeNotifyAlert(
        context: Context,
        msg: String?,
        strYes: String?,
        listenerYes: DialogInterface.OnClickListener?
    ) {
        showFreezeNotifyAlert(context, "", msg, strYes, listenerYes)
    }

    fun showFreezeNotifyAlert(
        context: Context,
        title: String?,
        msg: String?,
        strYes: String?,
        listenerYes: DialogInterface.OnClickListener?
    ) {
        showAlert(context, false, title, msg, strYes, listenerYes, null, null, null)
    }

    fun showFreezeNotifyAlert(
        context: Context,
        title: String?,
        msg: String?,
        strYes: String?,
        listenerYes: DialogInterface.OnClickListener?,
        strNo: String?,
        listenerNo: DialogInterface.OnClickListener?
    ) {
        showAlert(context, false, title, msg, strYes, listenerYes, strNo, listenerNo, null)
    }

    fun showIKnowAlert(context: Context, title: String?, msg: String?) {
        showNotifyAlert(context, title, msg, context.getString(R.string.i_know_it), null)
    }

    private fun showAlert(
        context: Context,
        cancelable: Boolean,
        title: String?,
        msg: String?,
        strYes: String?,
        listenerYes: DialogInterface.OnClickListener?,
        strNo: String?,
        listenerNo: DialogInterface.OnClickListener?,
        listenerCancel: DialogInterface.OnCancelListener?
    ) {
        try {
            val builder = AlertDialog.Builder(
                context,
//                R.style.NewOpenFlowDialogTheme
            )
            if (!TextUtils.isEmpty(title)) {
                builder.setTitle(Html.fromHtml("<b>" + title?.replace("\n", "<br>") + "</b>"))
            }
            builder.setMessage(msg)
            if (!TextUtils.isEmpty(strNo)) {
                builder.setNegativeButton(strNo, listenerNo)
            }
            if (!TextUtils.isEmpty(strYes)) {
                builder.setPositiveButton(strYes, listenerYes)
            }
            val dialog = builder.show()
            dialog.setCancelable(cancelable)
            dialog.setCanceledOnTouchOutside(cancelable)
            dialog.setOnCancelListener(listenerCancel)
            dialog.window?.setDimAmount(OVERLAY_ALPHA)

            // 在show之後才能調整內文顏色
            val messageView = dialog.findViewById<TextView>(R.id.message)
            messageView?.setTextColor(context.resources.getColor(R.color.black))
        } catch (e: Exception) {
            LogUtils.e(e.toString())
        }
    }

//    fun showBarCodeScannerDescAlert(context: Context?) {
//        context?.let { ctx ->
//            View.inflate(ctx, R.layout.barcode_scan_desc_alert_dialog, null).apply {
//                val dialog = AlertDialog.Builder(ctx)
//                    .setCancelable(false)
//                    .setView(this)
//                    .create()
//                dialog?.let {
//                    tv_positive.setText(ctx.getString(R.string.i_know_it), null, it)
//                    it.reSetNinetyDialogLayout(ctx, this)
//                    it.show()
//                }
//            }
//        }
//    }


    /**
     *
     *  if only single btn set Text in neutralText.
     *
     *  @param context Context
     *  @param iconRes res id default is R.drawable.ic_circle_call
     *  @param title alert title
     *  @param msg alert message
     *  @param rightButtonText right btn text
     *  @param rightButtonListener right btn click listener
     *  @param leftButtonText center btn text
     *  @param leftButtonListener center btn click listener
     * */
    fun showNormalAlert(
        context: Context?, iconRes: Int = R.drawable.ic_dialogs_bell, title: String? = "", msg: String? = "",
        rightButtonText: String? = null, rightButtonListener: View.OnClickListener? = null,
        leftButtonText: String? = null, leftButtonListener: View.OnClickListener? = null
    ) {
        context?.let { ctx ->
            val view = View.inflate(ctx, R.layout.normal_alert_dialog, null)
            NormalAlertDialogBinding.bind(view).run {
                ivIcon.setImageResource(iconRes)
                tvDialogTitle.text = title ?: ""
                if (!msg.isNullOrBlank()) {
                    tvDialogMsg.isVisible = true
                    tvDialogMsg.text = msg
                }
                AlertDialog.Builder(context).setCancelable(false).setView(view).create().apply {
                    (mbtnRightButton as TextView).setText(rightButtonText, rightButtonListener, this)
                    (mbtnLeftButton as TextView).setText(leftButtonText, leftButtonListener, this)
                    show()
                    window?.setBackgroundDrawableResource(R.color.transparent)
                    window?.setLayout(UiUtils.dpToPx(NORMAL_DIALOG_WIDTH), ViewGroup.LayoutParams.WRAP_CONTENT)
                    window?.setDimAmount(OVERLAY_ALPHA)
                }
            }
        }
    }

    private fun TextView.setText(btnText: String?, listener: View.OnClickListener?, dialog: AlertDialog) {
        if (!btnText.isNullOrEmpty()) {
            text = btnText
            this.setOnClickListener {
                listener?.onClick(it)
                dialog.dismiss()
            }
            visibility = View.VISIBLE
        } else {
            visibility = View.GONE
        }
    }

    private fun AlertDialog.reSetNinetyDialogLayout(context: Context, contentView: View) = let {
        val size = context.resources.displayMetrics
        val height = size.heightPixels * DIALOG_HEIGHT_RATIO

        showDialogWithTransparentBg(it, UiUtils.getWidthByScreen(it.context, DIALOG_LEFT_RIGHT_PADDING), height.toInt())
        val layoutParams = FrameLayout.LayoutParams(contentView.layoutParams.width, height.toInt(), Gravity.CENTER)
        layoutParams.topMargin += UiUtils.dpToPx(20)
        layoutParams.bottomMargin += UiUtils.dpToPx(20)
        contentView.layoutParams = layoutParams
        it.window?.setGravity(Gravity.CENTER)
    }

    private fun showDialogWithTransparentBg(dialog: AlertDialog, width: Int, height: Int) {
        try {
            dialog.show()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            if (width != 0 && height != 0) {
                dialog.window?.setLayout(width, height)
            }
        } catch (e: Exception) {
        }
    }
}